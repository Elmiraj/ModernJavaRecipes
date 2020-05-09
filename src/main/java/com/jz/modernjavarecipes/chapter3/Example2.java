package com.jz.modernjavarecipes.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 装箱流 class
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
public class Example2 {

    public static void main(String[] args) {
        // 使用 boxed 装箱
        List<Integer> list = IntStream.of(3, 1, 12, 2, 3).boxed().collect(Collectors.toList());
        System.out.println(list);
        // mapToObj 方法
        List<Integer> list2 = IntStream.of(3, 1, 12, 2, 3).mapToObj(Integer::valueOf).collect(Collectors.toList());
        System.out.println(list2);
        // collect 方法
        List<Integer> list3 = IntStream.of(3, 1, 12, 2, 3).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list3);
        // toArray 方法
        int[] intArray = IntStream.of(3, 1, 12, 2, 3).toArray();
        System.out.println(Arrays.stream(intArray));
    }
}
