package com.jz.modernjavarecipes.common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * GamePageLinksSupplier class
 *
 * @author Jun Zhang
 * @date 27/04/2020
 */
public class GamePageLinksSupplier implements Supplier<List<String>> {

    private static final String BASE = "http://gd2.mlb.com/components/game/mlb/";
    private LocalDate localDate;
    private int days;

    public GamePageLinksSupplier(LocalDate localDate, int days) {
        this.localDate = localDate;
        this.days = days;
    }

    public List<String> getGamePageLinks(LocalDate localDate) {
        return new ArrayList<>();
    }

    @Override
    public List<String> get() {
        return localDate.datesUntil(localDate.plusDays(days)).map(this::getGamePageLinks)
                .flatMap(list -> list.isEmpty() ? Stream.empty() : list.stream())
                .collect(Collectors.toList());
    }
}
