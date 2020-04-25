package com.jz.modernjavarecipes.chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * lambda 表达式内部访问的局部变量必须声明为 final 或具备等同于 final 效果 class
 *
 * @author Jun Zhang
 * @date 24/04/2020
 */
public class Example2 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 2, 1, 3, 4, 6, 5);
        int total;
//        integers.forEach(n -> total += n); // 错误的
        total = integers.stream().mapToInt(Integer::valueOf).sum();
        System.out.println(total);
    }
}
