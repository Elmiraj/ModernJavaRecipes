package com.jz.modernjavarecipes.chapter8;

import java.time.*;

/**
 * Data-Time API 基本类 class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println(Instant.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());
        System.out.println(ZonedDateTime.now());

        System.out.println("First landing on the moon: ");
        LocalDate moonLandingDate = LocalDate.of(1969, Month.JULY, 20);
        LocalTime moonLandingTime = LocalTime.of(20, 18);
        System.out.println("Date: " + moonLandingDate);
        System.out.println("Time: " + moonLandingTime);

        LocalDateTime walk = LocalDateTime.of(moonLandingDate, moonLandingTime);
        System.out.println(walk);
    }
}
