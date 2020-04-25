package com.jz.modernjavarecipes.chapter4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 根据长度对字符串排序
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
public class Example2 {
    public List<String> lengthSortUsingSorted(List<String> sampleList) {
        return sampleList.stream().sorted((s1, s2) -> s1.length() - s2.length()).collect(Collectors.toList());
    }

    public List<String> lengthSortUsingComparator(List<String> sampleList) {
        return sampleList.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }
}
