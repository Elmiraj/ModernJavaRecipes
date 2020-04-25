package com.jz.modernjavarecipes.chapter4;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 根据字典序（自然顺序）对字符串排序
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
public class Example1 {
    public static List<String> defaultSort(List<String> sampleList) {
        Collections.sort(sampleList);
        return sampleList;
    }

    public static List<String> defaultSortUsingStream(@NotNull List<String> sampleList) {
        return sampleList.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> sampleList = Arrays.asList("this", "is", "a", "string", "list");
        List<String> list = defaultSortUsingStream(sampleList);
        System.out.println(list);
    }
}
