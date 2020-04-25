package com.jz.modernjavarecipes.chapter6;

import com.jz.modernjavarecipes.common.GolfClub;
import com.jz.modernjavarecipes.common.Golfer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example2 class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Example2 {
    public Optional<Integer> findGolfClubById(Integer id) {
        return Optional.ofNullable(id);
    }

    public List<Integer> findGolfClubByIds(List<Integer> ids) {
        return ids.stream().map(this::findGolfClubById)
//                .flatMap(optional -> optional.map(Stream::of).orElseGet(Stream::empty))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {

    }
}
