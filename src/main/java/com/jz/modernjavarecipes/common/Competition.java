package com.jz.modernjavarecipes.common;

import java.util.Optional;

/**
 * 高尔夫比赛 class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Competition {
    private Golfer golfer;

    public Optional<Golfer> getGolfer() {
        return Optional.ofNullable(golfer);
    }

    public void setGolfer(Golfer golfer) {
        this.golfer = golfer;
    }
}
