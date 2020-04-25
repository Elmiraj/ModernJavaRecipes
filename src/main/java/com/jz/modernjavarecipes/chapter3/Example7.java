package com.jz.modernjavarecipes.chapter3;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 查找流中的第一个或任意一个数 class
 *
 * @author Jun Zhang
 * @date 24/04/2020
 */
public class Example7 {

    public static Integer delay(Integer n) {
        try {
            Thread.sleep((long) (Math.random() * 100));
            System.out.println(Thread.currentThread().toString() + n);
        } catch (InterruptedException ignored) {
            ignored.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        Optional<Integer> any = Stream.of(1, 2, 3, 7, 5, 3, 6)
                .unordered()
                .parallel()
                .map(Example7::delay)
                .findAny();
        System.out.println("Any: " + any);
    }
}
