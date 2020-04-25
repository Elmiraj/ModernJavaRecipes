package com.jz.modernjavarecipes.chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 对文件系统进行深度优先遍历 class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Example3 {
    public static void main(String[] args) {
        try (Stream<Path> walk = Files.walk(Paths.get("src/main/java"), Integer.MAX_VALUE)) {
            walk.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
