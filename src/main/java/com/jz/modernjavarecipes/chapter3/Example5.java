package com.jz.modernjavarecipes.chapter3;

import java.util.stream.Stream;

/**
 * 回文检查器 class
 *
 * @author Jun Zhang
 * @date 23/04/2020
 */
public class Example5 {

    public static boolean isPalindrome(String s) {
        String forward = s.toLowerCase().codePoints()
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        String backward = new StringBuilder(forward).reverse().toString();
        return forward.equals(backward);
    }

    public static void main(String[] args) {
        boolean b = Stream.of("this is a string").allMatch(Example5::isPalindrome);
        System.out.println(b);
    }
}
