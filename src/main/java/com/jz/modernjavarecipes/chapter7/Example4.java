package com.jz.modernjavarecipes.chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 文件系统的搜索 class
 *
 * @author Jun Zhang
 * @date 25/04/2020
 */
public class Example4 {
    public static void main(String[] args) {
        try (Stream<Path> find = Files.find(Paths.get("src/main/java"),
                Integer.MAX_VALUE, ((path, basicFileAttributes) -> !basicFileAttributes.isDirectory() &&
                        path.toString().contains("7")))) {
            find.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
