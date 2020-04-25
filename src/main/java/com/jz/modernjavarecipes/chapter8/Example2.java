package com.jz.modernjavarecipes.chapter8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * TemporalAdjuster class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Example2 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2020, Month.APRIL, 25);
        LocalDate adjustDate = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(adjustDate);
        System.out.println(localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
    }
}
