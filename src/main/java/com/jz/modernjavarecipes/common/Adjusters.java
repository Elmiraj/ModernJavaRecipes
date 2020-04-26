package com.jz.modernjavarecipes.common;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

/**
 * 工具类Adjusters，同 PayDayAdjuster class
 *
 * @author Jun Zhang
 * @date 26/04/2020
 */
public class Adjusters {
    public static Temporal adjustInfo(Temporal temporal) {
        LocalDate date = LocalDate.from(temporal);
        final int fifteen = 15;
        int day;
        if (date.getDayOfMonth() < fifteen) {
            day = 15;
        } else {
            day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
        }

        date = date.withDayOfMonth(day);
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }
        return temporal.with(date);
    }
}
