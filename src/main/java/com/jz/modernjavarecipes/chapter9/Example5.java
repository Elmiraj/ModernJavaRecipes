package com.jz.modernjavarecipes.chapter9;

import java.util.concurrent.CompletableFuture;

/**
 * 利用 CompletableFuture 协调多个任务 class
 *
 * @author Jun Zhang
 * @date 27/04/2020
 */
public class Example5 {
    private static String sleepThenReturnString() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException("asd");
        }
        return "42";
    }

    private static void apply() {
        CompletableFuture.supplyAsync(Example5::sleepThenReturnString)
                .thenApply(Integer::parseInt)
                .thenApply(x -> x * 2)
                .thenAccept(System.out::println)
                .join();
    }

    private static Integer compose() {
        int x = 3;
        int y = 4;
        return CompletableFuture.supplyAsync(() -> x)
                .thenCompose(n -> CompletableFuture.supplyAsync(() -> n + y)).join();
    }

    private static Integer combine() {
        int x = 3;
        int y = 4;
        return CompletableFuture.supplyAsync(() -> x)
                .thenCombine(CompletableFuture.supplyAsync(() -> y), Integer::sum).join();
    }

    public static void main(String[] args) {
        apply();

        System.out.println(compose());
        System.out.println(combine());
        System.out.println("Running...");
    }
}
