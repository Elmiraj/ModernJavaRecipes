package com.jz.modernjavarecipes.chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer接口 class
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
public class Example1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        // 匿名内部类实现
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // lambda 表达式
        strings.forEach(s -> System.out.println(s));
        // 方法引用
        strings.forEach(System.out::println);
    }
}
