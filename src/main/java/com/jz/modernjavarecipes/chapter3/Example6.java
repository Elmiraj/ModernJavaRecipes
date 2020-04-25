package com.jz.modernjavarecipes.chapter3;

import com.jz.modernjavarecipes.common.Golfer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * 汇总统计 class
 *
 * @author Jun Zhang
 * @date 23/04/2020
 */
public class Example6 {
    public static void main(String[] args) {
        DoubleSummaryStatistics statistics = DoubleStream.generate(Math::random)
                .limit(10000)
                .summaryStatistics();

        List<Golfer> golfers = Arrays.asList(
                new Golfer("Jack", "Nicklaus", 68),
                new Golfer("Tiger", "Woods", 70),
                new Golfer("Tom", "Watson", 71)
        );

        DoubleSummaryStatistics doubleSummaryStatistics =
                golfers.stream().collect(Collectors.summarizingDouble(Golfer::getScore));

        System.out.println(statistics);
        System.out.println(doubleSummaryStatistics);
        System.out.println("count: " + statistics.getCount());
        System.out.println("max: " + statistics.getMax());
        System.out.println("min: " + BigDecimal.valueOf(statistics.getMin()));
        System.out.println("average: " + statistics.getAverage());
        System.out.println("sum: " + statistics.getSum());
    }
}
