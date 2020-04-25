package com.jz.modernjavarecipes.chapter3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 创建流 class
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
public class Example1 {
    public static void main(String[] args) {
        // Stream.of 方法创建流
        String names = Stream.of("Tom", "Jerry", "Jeremy", "Clarkson").collect(Collectors.joining(","));
        System.out.println(names);

        // Arrays.stream 方法创建流
        String[] names2 = {"Tom", "Jerry", "Jeremy", "Clarkson"};
        String names3 = Arrays.stream(names2).collect(Collectors.joining(","));
        System.out.println(names3);

        // Stream.iterate 创建流
        List<BigDecimal> nums =
                Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE)).limit(10).collect(Collectors.toList());
        System.out.println(nums);

        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1L)).limit(10).forEach(System.out::println);

        // Math.random 创建随机流
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        // range 和 rangeClosed 方法
        System.out.println(IntStream.range(10, 15).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(10, 15).boxed().collect(Collectors.toList()));
    }
}
