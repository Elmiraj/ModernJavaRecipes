package com.jz.modernjavarecipes.chapter4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 根据长度对字符串排序，长度相同则按字母顺序排序
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
public class Example3 {
    public List<String> lengthSortThenAlphaSort(List<String> sampleList) {
        return sampleList.stream().sorted(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

}
