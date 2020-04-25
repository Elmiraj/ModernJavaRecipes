package com.jz.modernjavarecipes.chapter4;

import com.jz.modernjavarecipes.common.Golfer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * toMap class
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
public class Example6 {

    public static void main(String[] args) {
        List<Golfer> golferList = Arrays.asList(
                new Golfer("Tom", "Clark", 70),
                new Golfer("Jerry", "Steve", 90)
        );

        Map<String, Golfer> golferMap = golferList.stream().collect(Collectors.toMap(Golfer::getFirstName, a -> a));

        Map<String, Golfer> golferMap2 = golferList.stream().collect(Collectors.toMap(Golfer::getFirstName,
                UnaryOperator.identity()));
        System.out.println(golferMap2);
    }

}
