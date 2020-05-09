package com.jz.modernjavarecipes.chapter10;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        System.out.println(list.add(9));

        // java 8 实现
        List<BigDecimal> bigDecimals = Stream.iterate(BigDecimal.ZERO,
                bd -> bd.add(BigDecimal.ONE)
        ).limit(10).collect(Collectors.toList());

        // java 9 实现
        bigDecimals = Stream.iterate(BigDecimal.ZERO,
                bd -> bd.longValue() < 10L,
                bd -> bd.add(BigDecimal.ONE))
                .collect(Collectors.toList());
        System.out.println(bigDecimals);

        // 返回谓词之前的元素，不包括谓词
        list.stream().takeWhile(s -> s != 3).forEach(System.out::println);
        // 返回谓词之后的元素，包括谓词
        list.stream().dropWhile(s -> s != 3).forEach(System.out::println);
    }
}
