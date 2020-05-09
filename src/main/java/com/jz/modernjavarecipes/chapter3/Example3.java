package com.jz.modernjavarecipes.chapter3;

import java.util.Arrays;

/**
 * Example3 class
 *
 * @author Jun Zhang
 * @date 23/04/2020
 */
public class Example3 {
    public static void main(String[] args) {
        String[] strings = "".split("");
        long count = Arrays.stream(strings).count();
        System.out.println("There are " + count + " strings");
    }
}
