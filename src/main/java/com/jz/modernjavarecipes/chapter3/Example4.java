package com.jz.modernjavarecipes.chapter3;

import java.util.stream.IntStream;

/**
 * 使用peek对流进行调试 class
 *
 * @author Jun Zhang
 * @date 23/04/2020
 */
public class Example4 {

    public static int sumDoublesDivideByThree(int start, int end) {
        return IntStream.range(start, end)
                .peek(System.out::println)
                .map(n -> n * 2)
                .peek(n -> System.out.printf("doubled : %d%n", n))
                .filter(n -> n % 3 == 0).sum();
    }

    public static void main(String[] args) {
        System.out.println(sumDoublesDivideByThree(1, 10));
        System.out.println(sumDoublesDivideByThree(2, 20));
    }
}
