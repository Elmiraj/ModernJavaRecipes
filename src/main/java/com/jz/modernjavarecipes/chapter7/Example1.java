package com.jz.modernjavarecipes.chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用 Files.lines 进行文件处理 class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Example1 {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("");
        try (Stream<String> lines = Files.lines(Path.of("/usr/share/dict/web2"))) {
            lines.filter(s -> s.length() > 20)
                    .sorted(Comparator.comparingInt(String::length).reversed()
                            .thenComparing(Comparator.reverseOrder()))
                    .limit(10)
                    .forEach(w -> System.out.printf("%s (%d)%n", w, w.length()));


        } catch (IOException e) {
            logger.info(e.getMessage());
        }

        try (Stream<String> lines = Files.lines(Path.of("/usr/share/dict/web2"))) {
            lines.filter(s -> s.length() > 20)
                    .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                    .forEach((len, num) -> System.out.println(len + ": " + num));
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }
}
