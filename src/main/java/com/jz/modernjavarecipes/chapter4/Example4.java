package com.jz.modernjavarecipes.chapter4;

import com.jz.modernjavarecipes.common.Golfer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对高尔夫球手进行排序
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
public class Example4 {

    public static List<Golfer> sortByScoreThenFirstThenLst(List<Golfer> golfers) {
        return golfers.stream().sorted(Comparator.comparingInt(Golfer::getScore)
                .thenComparing(Golfer::getFirstName).thenComparing(Golfer::getLastName)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Golfer> golfers = Arrays.asList(
                new Golfer("Jack", "Nicklaus", 68),
                new Golfer("Tiger", "Woods", 70),
                new Golfer("Tom", "Watson", 70)
        );
        List<Golfer> list = sortByScoreThenFirstThenLst(golfers);
        System.out.println(list);
    }
}
