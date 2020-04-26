package com.jz.modernjavarecipes.chapter8;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * 时间转换 class
 *
 * @author Jun Zhang
 * @date 26/04/2020
 */
public class Example5 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        System.out.println(new java.sql.Date(date.getTime()).toLocalDate());
        System.out.println(LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault()));

    }
}
