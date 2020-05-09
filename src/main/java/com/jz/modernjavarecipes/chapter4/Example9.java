package com.jz.modernjavarecipes.chapter4;

import com.jz.modernjavarecipes.common.Golfer;

import java.util.*;
import java.util.function.BinaryOperator;

public class Example9 {
    public static void main(String[] args) {
        List<Golfer> golfers = Arrays.asList(
                new Golfer("Jack", "Nicklaus", 68),
                new Golfer("Tiger", "Woods", 70),
                new Golfer("Tom", "Watson", 71)
        );

        Golfer defaultGolfer = new Golfer("Jeremy", "Clarkson", 20);

        Optional<Golfer> optionalGolfer = golfers.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(Golfer::getScore)));

        Optional<Golfer> optionalGolferStream = golfers.stream().max(Comparator.comparingInt(Golfer::getScore));

        System.out.println("Max Score is: " + optionalGolfer.orElse(defaultGolfer));
        System.out.println("Max Score is: " + optionalGolferStream.orElse(defaultGolfer));
    }
}
