package com.jz.modernjavarecipes.chapter8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * 日期格式化 class
 *
 * @author Jun Zhang
 * @date 26/04/2020
 */
public class Example6 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        //Full: Sunday, 26 April 2020
        System.out.println("Full: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        //Long: 26 April 2020
        System.out.println("Long: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        //Medium: 26 Apr 2020
        System.out.println("Medium: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        //Short: 26/04/2020
        System.out.println("Short: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));

        System.out.println("Japan: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.JAPAN)));

    }
}
