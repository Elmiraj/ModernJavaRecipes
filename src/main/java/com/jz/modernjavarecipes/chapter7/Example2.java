package com.jz.modernjavarecipes.chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 以流的形式检索文件 class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Example2 {
    public static void main(String[] args) {
        try (Stream<Path> list = Files.list(Paths.get("src/main/java/com/jz/modernjavarecipes"))) {
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
