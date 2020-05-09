package com.jz.modernjavarecipes.chapter4;

import com.jz.modernjavarecipes.common.Golfer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 创建set, list 和 map class
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
public class Example5 {
    public static void main(String[] args) {
        List<String> listList = Stream.of("Tom", "Jerry", "Jerry", "Chaos").collect(Collectors.toList());
        Set<String> setSet = Stream.of("Tom", "Jerry", "Jerry", "Chaos").collect(Collectors.toSet());
        List<String> linkedList =
                Stream.of("Tom", "Jerry", "Jerry", "Chaos").collect(Collectors.toCollection(LinkedList::new));

        String[] wannabes = Stream.of("The Waffler", "Reverse Psychologist", "PMS avenger").toArray(String[]::new);

        Set<Golfer> golferSet = Set.of(
                new Golfer("Tom", "Clark"),
                new Golfer("Jerry", "Steve")
        );
        Map<String, String> golferMap = golferSet.stream().collect(Collectors.toMap(Golfer::getFirstName,
                Golfer::getLastName));
        golferMap.forEach((key, value) ->
                System.out.printf("firstName %s lastName %s%n", key, value));

        System.out.println(listList);
        System.out.println(setSet);
        System.out.println(linkedList);
        System.out.println(Arrays.toString(wannabes));
    }
}
