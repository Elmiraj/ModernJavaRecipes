package com.jz.modernjavarecipes.chapter8;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;

/**
 * TemporalQuery class
 *
 * @author Jun Zhang
 * @date 26/04/2020
 */
public class Example4 {
    private static long daysUntilPirateDay(TemporalAccessor temporalAccessor) {
        int year = temporalAccessor.get(ChronoField.YEAR);
        int month = temporalAccessor.get(ChronoField.MONTH_OF_YEAR);
        int day = temporalAccessor.get(ChronoField.DAY_OF_MONTH);
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate pirateDay = LocalDate.of(temporalAccessor.get(ChronoField.YEAR), Month.SEPTEMBER, 19);
        if (date.isAfter(pirateDay)) {
            pirateDay = pirateDay.plusYears(1);
        }
        return ChronoUnit.DAYS.between(date, pirateDay);
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.now().query(TemporalQueries.precision()));
        System.out.println(LocalDate.now().query(TemporalQueries.localDate()));
        LocalDate now = LocalDate.now();
        System.out.println(daysUntilPirateDay(now));
    }
}
