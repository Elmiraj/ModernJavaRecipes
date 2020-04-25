package com.jz.modernjavarecipes.chapter6;

import com.jz.modernjavarecipes.common.Competition;
import com.jz.modernjavarecipes.common.GolfClub;
import com.jz.modernjavarecipes.common.Golfer;

import java.util.Optional;

/**
 * Optional 映射 class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Example3 {
    public static void main(String[] args) {
        Competition co = new Competition();
        Optional<Competition> competition = Optional.of(co);

        System.out.println(competition
                .flatMap(Competition::getGolfer)
                .flatMap(Golfer::getGolfClub)
                .map(GolfClub::getId));
    }
}
