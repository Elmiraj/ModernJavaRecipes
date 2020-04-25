package com.jz.modernjavarecipes.chapter3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 查询是否为质数的方法 class
 *
 * @author Jun Zhang
 * @date 23/04/2020
 */
public class Example8 {
    public static boolean isPrime(int num) {
        int limit = (int) (Math.sqrt(num));
        return num == 2 || num > 1 && IntStream.rangeClosed(2, limit)
                .noneMatch(divisor -> num % divisor == 0);
    }

    public static void main(String[] args) {
        Stream.of(9, 6, 10).forEach(
                n -> System.out.println(n + "是否是质数：" + isPrime(n))
        );
    }
}
