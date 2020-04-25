package com.jz.modernjavarecipes.chapter5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 抛出异常 unchecked exception class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Example5 {
    public static List<Integer> div(List<Integer> values, Integer factor) {
        return values.stream().map(n -> n / factor).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> values = Stream.iterate(1, n -> n + 1).limit(10).collect(Collectors.toList());
        int y = 0;
        System.out.println(div(values, y));
    }
}
