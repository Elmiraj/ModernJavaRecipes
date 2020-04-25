package com.jz.modernjavarecipes.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * partitioningBy & groupingBy class
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
public class Example8 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "defg", "hijkl", "mnopq", "rst", "uv", "wxyz");
        // 无下游收集器
        Map<Boolean, List<String>> lengthMap =
                list.stream().collect(Collectors.partitioningBy(s -> s.length() % 2 == 0));

        // 有下游收集器
        Map<Boolean, Long> lengthMapWithDownstreamCollector =
                list.stream().collect(Collectors.partitioningBy(s -> s.length() % 2 == 0, Collectors.counting()));

        Map<Integer, List<String>> lengthGroupingByMap =
                list.stream().collect(Collectors.groupingBy(String::length));

        Map<Integer, List<String>> lengthMaxMap =
                list.stream().collect(Collectors.groupingBy(String::length));

        lengthMap.forEach((k, v) -> System.out.printf("%5s: %s%n", k, v));
        lengthMapWithDownstreamCollector.forEach((k, v) -> System.out.printf("%5s : %d%n", k, v));
        lengthGroupingByMap.forEach((k, v) -> System.out.printf("%d : %s%n", k, v));
    }
}
