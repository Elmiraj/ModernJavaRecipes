package com.jz.modernjavarecipes.chapter9;

import com.jz.modernjavarecipes.common.Golfer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

/**
 * CompletableFuture class
 *
 * @author Jun Zhang
 * @date 27/04/2020
 */
public class Example4 {
    private static Map<Integer, Golfer> cache = new HashMap<>();
    private static final Logger logger = Logger.getLogger(Example4.class.getName());

    private static Golfer getLocal(int id) {
        return cache.get(id);
    }

    private static Golfer getRemote(int id) {
        try {
            Thread.sleep(10);
            if (id == 666) {
                throw new RuntimeException("Evil request");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Golfer("firstName666");
    }

    public static CompletableFuture<Golfer> getGolfer(int id) {
        try {
            Golfer golfer = getLocal(id);
            if (golfer != null) {
                return CompletableFuture.completedFuture(golfer);
            } else {
                CompletableFuture<Golfer> future = new CompletableFuture<>();
                Golfer g = getRemote(id);
                cache.put(id, g);
                future.complete(g);
                return future;
            }
        } catch (Exception e) {
            CompletableFuture<Golfer> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public static CompletableFuture<Golfer> getGolferAsync(int id) {
        try {
            Golfer golfer = getLocal(id);
            if (golfer != null) {
                logger.info("get local with id: " + id);
                return CompletableFuture.completedFuture(golfer);
            } else {
                logger.info("get remote with id: " + id);
//                return CompletableFuture.supplyAsync(Example4::putCache);
                return CompletableFuture.supplyAsync(() -> putCache(id));
//                return IntStream.of(id).mapToObj(Example4::putCache).reduce()
//                return CompletableFuture.supplyAsync(() -> {
//                    Golfer g = getRemote(id);
//                    cache.put(id, g);
//                    return g;
//                });
            }
        } catch (Exception e) {
            logger.info("Exception thrown");
            CompletableFuture<Golfer> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    private static Golfer putCache(int id) {
//        int id = 0;
        Golfer g = getRemote(id);
        cache.put(id, g);
        return g;
    }

    public static void main(String[] args) {

        try {
            System.out.println(getGolfer(666).get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }

    }
}
