package com.jz.modernjavarecipes.chapter8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 根据 UTC 偏移量查找地区名 class
 *
 * @author Jun Zhang
 * @date 26/04/2020
 */
public class Example8 {
    private static List<String> getRegionNamesForOffset(ZoneOffset offset) {
        LocalDateTime now = LocalDateTime.now();
        return ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId::of)
                .filter(zoneId -> now.atZone(zoneId).getOffset().equals(offset))
                .map(ZoneId::toString)
                .sorted()
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        ZoneOffset offset = now.getOffset();
        // 通过 GMT 偏移量获取地区名
        ZoneOffset gmtOffSet = ZoneOffset.ofHoursMinutes(9, 0);
        getRegionNamesForOffset(offset).forEach(System.out::println);
        getRegionNamesForOffset(gmtOffSet).forEach(System.out::println);
    }
}
