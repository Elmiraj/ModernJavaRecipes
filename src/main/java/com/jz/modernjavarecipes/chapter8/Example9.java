package com.jz.modernjavarecipes.chapter8;

import java.time.*;
import java.time.temporal.*;

/**
 * 获取事件之间的时间 class
 *
 * @author Jun Zhang
 * @date 26/04/2020
 */
public class Example9 {
    public static void main(String[] args) {
        LocalDate electionDay = LocalDate.of(2020, Month.NOVEMBER, 3);
        LocalDate now = LocalDate.now();
        System.out.println(ChronoUnit.DAYS.between(now, electionDay));
        System.out.println(ChronoUnit.WEEKS.between(now, electionDay));

        Period between = Period.between(now, electionDay);
        Period until = now.until(electionDay);
        int month = between.getMonths();
        System.out.println(until);
        System.out.println(month);

        Instant nowInstant = Instant.now();
        Instant nextYearInstant = nowInstant.plus(365, ChronoUnit.DAYS);
        System.out.println(Duration.between(nowInstant, nextYearInstant).toDays());
    }
}
