package com.jz.modernjavarecipes.chapter9;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Future class
 *
 * @author Jun Zhang
 * @date 27/04/2020
 */
public class Example3 {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory);
        Future<String> future = executorService.submit(() ->
        {
            Thread.sleep(100);
            return "Hello World";
        });
        future.cancel(true);
        System.out.println("Processing");
        getIfNotCancelled(future);
    }

    private static void getIfNotCancelled(Future<String> future) {
        try {
            if (!future.isCancelled()) {
                System.out.println(future.get());
            } else {
                System.out.println("Cancelled");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
