package com.jz.modernjavarecipes.chapter5;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 复合函数 class
 *
 * @author Jun Zhang
 * @date 24/04/2020
 */
public class Example4 {
    private static boolean isPerfect(int x) {
        return Math.sqrt(x) % 1 == 0;
    }

    public static boolean isTriangle(int y) {
        return (Math.sqrt(8 * y + 1) - 1) / 2 % 1 == 0;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> add2 = x -> x + 2;
        Function<Integer, Integer> multi3 = x -> x * 3;
        Function<Integer, Integer> add2Multi3 = add2.andThen(multi3);
        Function<Integer, Integer> multi3Add2 = add2.compose(multi3);
        System.out.println("add2Multi3: " + add2Multi3.apply(10));
        System.out.println("multi3Add2: " + multi3Add2.apply(10));

        Logger log = Logger.getLogger("");
        Consumer<String> printer = System.out::println;
        Consumer<String> logger = log::info;
        Consumer<String> printThenLog = printer.andThen(logger);
        Stream.of("this", "is", "a", "log").forEach(printThenLog);

        IntPredicate perfect = Example4::isPerfect;
        IntPredicate triangle = Example4::isTriangle;
        IntPredicate both = perfect.and(triangle);
        IntStream.rangeClosed(1, 1_000).filter(both).forEach(System.out::println);

    }
}
