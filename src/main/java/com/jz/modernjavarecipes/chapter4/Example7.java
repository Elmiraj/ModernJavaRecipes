package com.jz.modernjavarecipes.chapter4;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 对映射排序 class
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
public class Example7 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("abc", "defg", "hijkl", "mnopq", "rst", "uv", "wxyz");
        stream.collect(Collectors.groupingBy(String::length, Collectors.counting())).forEach((len, num) ->
                System.out.printf("%d: %d%n", len, num));

        Stream<String> newStream = Stream.of("abc", "defg", "hijkl", "mnopq", "rst", "uv", "wxyz");
        
        // Comparator.reverseOrder() 以键的相反顺序排序
        Map<Integer, Long> map = newStream.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(e ->
                System.out.printf("%d: %d%n", e.getKey(), e.getValue()));
    }
}
