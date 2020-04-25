package com.jz.modernjavarecipes.common;

import lombok.Data;

/**
 * 球杆 class
 *
 * @author Jun Zhang
 * @date 23/04/2020
 */
@Data
public class GolfClub {
    private int id;

    public GolfClub(int id) {
        this.id = id;
    }
}
