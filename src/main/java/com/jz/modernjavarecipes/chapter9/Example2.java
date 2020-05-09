package com.jz.modernjavarecipes.chapter9;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 调整线程池的大小 class
 *
 * @author Jun Zhang
 * @date 27/04/2020
 */
public class Example2 {
    public static void main(String[] args) {
        long total = 0;
        ForkJoinPool forkJoinPool = new ForkJoinPool(15);
        ForkJoinTask<Long> task = forkJoinPool.submit(
                () -> LongStream.rangeClosed(1, 3_000_000)
                        .parallel()
                        .sum()
        );
        try {
            total = task.get();
        } catch (InterruptedException | ExecutionException exception) {
            exception.printStackTrace();
        } finally {
            forkJoinPool.shutdown();
        }

        int poolSize = forkJoinPool.getPoolSize();
        System.out.println("Pool Size: " + poolSize);
        System.out.println(total);
    }
}
