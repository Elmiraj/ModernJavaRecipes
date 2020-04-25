package com.jz.modernjavarecipes.chapter6;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 从 Optional 中检索值 class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Example1 {
    public static void main(String[] args) {
        Optional<String> firstEven = Stream.of("first", "of", "string")
                .filter(s -> s.length() % 2 == 0)
                .findFirst();
        System.out.println(firstEven.orElse("no even string"));
        System.out.println(firstEven.orElseThrow(NoSuchElementException::new));
        firstEven.ifPresent(val -> System.out.println("no even string"));
    }
}
