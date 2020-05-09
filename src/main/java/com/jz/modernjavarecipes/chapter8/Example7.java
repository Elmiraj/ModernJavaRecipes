package com.jz.modernjavarecipes.chapter8;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;

/**
 * 非整数时区偏移量 class
 *
 * @author Jun Zhang
 * @date 26/04/2020
 */
public class Example7 {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        ZonedDateTime current = instant.atZone(ZoneId.systemDefault());
        System.out.printf("Current time is %s%n%n", current);
        System.out.printf("%10s %2s %13s%n", "OffSet", "ZoneId", "Time");

        ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId::of)
                .filter(zoneId -> {
                    ZoneOffset offset = instant.atZone(zoneId).getOffset();
                    return offset.getTotalSeconds() % (60 * 60) != 0;
                })
                .sorted(Comparator.comparingInt(zoneId -> instant.atZone(zoneId).getOffset().getTotalSeconds()))
                .forEach(zoneId -> {
                    ZonedDateTime zonedDateTime = current.withZoneSameInstant(zoneId);
                    System.out.printf("%10s %22s %13s%n", zonedDateTime.getOffset(),
                            zoneId, zonedDateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
                });
    }
}
