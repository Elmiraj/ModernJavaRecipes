package com.jz.modernjavarecipes.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Golfer class
 *
 * @author Jun Zhang
 * @date 22/04/2020
 */
@Data
public class Golfer {
    private String firstName;
    private String lastName;
    private int score;
    private List<GolfClub> golfClubList = new ArrayList<>();

    public Golfer(String firstName) {
        this.firstName = firstName;
    }

    public Golfer(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public Golfer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Golfer addGolfClub(GolfClub golfClub) {
        golfClubList.add(golfClub);
        return this;
    }
}
