package com.jz.modernjavarecipes.chapter8;

import com.jz.modernjavarecipes.common.Adjusters;
import com.jz.modernjavarecipes.common.PayDayAdjuster;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.IntStream;

/**
 * with temporalAdjuster class
 *
 * @author Jun Zhang
 * @date 26/04/2020
 */
public class Example3 {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfMonth()));
        // 不包括今天
        System.out.println(localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        // 包括今天
        System.out.println(localDateTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)));

        TemporalAdjuster payDayAdjuster = new PayDayAdjuster();
        IntStream.rangeClosed(1, 14).mapToObj(day -> LocalDate.of(2020, Month.APRIL, day))
                .forEach(date -> System.out.println(date.with(payDayAdjuster).getDayOfMonth()));
        IntStream.rangeClosed(15, 30).mapToObj(day -> LocalDate.of(2020, Month.APRIL, day))
                .forEach(date -> System.out.println(date.with(payDayAdjuster).getDayOfMonth()));

        IntStream.rangeClosed(15, 30).mapToObj(day -> LocalDate.of(2020, Month.APRIL, day))
                .forEach(date -> System.out.println(date.with(Adjusters::adjustInfo).getDayOfMonth()));
    }
}
