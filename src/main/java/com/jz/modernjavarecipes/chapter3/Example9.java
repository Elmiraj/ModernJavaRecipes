package com.jz.modernjavarecipes.chapter3;

import com.jz.modernjavarecipes.common.GolfClub;
import com.jz.modernjavarecipes.common.Golfer;

import java.util.Arrays;
import java.util.List;

/**
 * flatMap class
 *
 * @author Jun Zhang
 * @date 23/04/2020
 */
public class Example9 {
    public static void main(String[] args) {
        Golfer tiger = new Golfer("Tiger");
        Golfer woods = new Golfer("Woods");
        Golfer gutenberg = new Golfer("Gutenberg");

        tiger.addGolfClub(new GolfClub(1)).addGolfClub(new GolfClub(2));
        woods.addGolfClub(new GolfClub(1)).addGolfClub(new GolfClub(3)).addGolfClub(new GolfClub(2));

        List<Golfer> golfers = Arrays.asList(tiger, woods, gutenberg);

        golfers.stream().map(Golfer::getGolfClubList).forEach(System.out::println);
        golfers.stream().flatMap(golfer -> golfer.getGolfClubList().stream()).forEach(System.out::println);
    }
}
