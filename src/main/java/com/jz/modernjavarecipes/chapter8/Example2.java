package com.jz.modernjavarecipes.chapter8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.logging.Logger;

/**
 * TemporalAdjuster class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Example2 {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("");
        LocalDate localDate = LocalDate.of(2020, Month.APRIL, 25);
        LocalDate adjustDate = localDate.with(TemporalAdjusters.lastDayOfMonth());
        try {
            LocalDate febDay = LocalDate.of(2017, Month.FEBRUARY, 1);
            System.out.println(febDay.withDayOfMonth(29));
        } catch (DateTimeException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }
        LocalDateTime temporal = LocalDateTime.of(2012, 3, 31, 10, 30);
        System.out.println(temporal.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(temporal.with(ChronoField.MONTH_OF_YEAR, 2));
        System.out.println(adjustDate);
        System.out.println(localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
    }
}
