package com.jz.modernjavarecipes.common;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openjdk.jmh.results.Result;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * BoxscoreRetriever class
 *
 * @author Jun Zhang
 * @date 27/04/2020
 */
public class BoxscoreRetriever implements Function<List<String>, List<Result>> {
    private static final String BASE = "http://gd2.mlb.com/components/game/mlb/";
    private OkHttpClient okHttpClient = new OkHttpClient();
    private Gson gson = new Gson();
    private LocalDate localDate;

    @SuppressWarnings("ConstantConditions")
    public Optional<Result> gamePattern2Result(String pattern) {
        String dateUrl =
                "year_" + localDate.getYear() + "/month_" + localDate.getMonth() + "/day_" + localDate.getDayOfMonth();
        String boxscoreUrl = BASE + dateUrl + pattern + "boxscore.json";
        Request request = new Request.Builder()
                .url(boxscoreUrl)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                System.out.println("Box score not found for " + boxscoreUrl);
                return Optional.empty();
            }
            return Optional.ofNullable(
                    gson.fromJson(response.body().charStream(), Result.class)
            );
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Result> apply(List<String> strings) {
        return strings.parallelStream()
                .map(this::gamePattern2Result)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public void saveResultList(List<Result> results) {
        results.parallelStream().forEach(this::saveResultToFile);
    }

    public void saveResultToFile(Result result) {
        String dir = "";
        String fileName = "";
        try {
            File file = new File(dir + "/" + fileName);
            Files.write(file.toPath().toAbsolutePath(), gson.toJson(result).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getTotalScore(Result result) {
        return 42;
    }

    public OptionalInt getMaxScore(List<Result> results) {
        return results.stream().mapToInt(this::getTotalScore).max();
    }

    public Optional<Result> getMaxGame(List<Result> results) {
        return results.stream().max(Comparator.comparingInt(this::getTotalScore));
    }

    public void printGame(LocalDate startDate, int days) {
        CompletableFuture<List<Result>> future = CompletableFuture.supplyAsync(
                new GamePageLinksSupplier(startDate, days)
        ).thenApply(new BoxscoreRetriever());

        CompletableFuture<Void> futureWrite =
                future.thenAcceptAsync(this::saveResultList)
                        .exceptionally(e -> {
                                    System.err.println(e.getMessage());
                                    return null;
                                }
                        );

        CompletableFuture<OptionalInt> futureMaxScore = future.thenApplyAsync(this::getMaxScore);
        CompletableFuture<Optional<Result>> futureMaxGame = future.thenApplyAsync(this::getMaxGame);
        CompletableFuture<String> futureMax = futureMaxScore.thenCombineAsync(
                futureMaxGame, (score, result) -> String.format("Highest score: %d, Max Game: %s",
                        score.orElse(0), result.orElse(null))
        );

        CompletableFuture.allOf(futureWrite, futureMax).join();

        future.join().forEach(System.out::println);
        System.out.println(futureMax.join());
    }
}
