package com.jz.modernjavarecipes.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 用静态工具方法实现非空验证等操作 class
 *
 * @author Jun Zhang
 * @date 24/04/2020
 */
public class Example1 {

    public static void main(String[] args) {
        String[] strings = {"1", "2", "3", null, ""};
        List<String> stringList = Arrays.stream(strings).filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(stringList);
    }
}
