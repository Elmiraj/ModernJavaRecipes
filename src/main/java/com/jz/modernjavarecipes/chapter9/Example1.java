package com.jz.modernjavarecipes.chapter9;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 使用 JMH 计算不同的流求和所产生的消耗 class
 *
 * @author Jun Zhang
 * @date 26/04/2020
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
public class Example1 {

    private static final long ONE_HUNDRED_THOUSAND = 10_000_000;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Example1.class.getSimpleName())
                .warmupIterations(20)
                .measurementIterations(20)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public long iterativeSum() {
        long result = 0;
        for (long i = 1L; i <= ONE_HUNDRED_THOUSAND; i++) {
            result += i;
        }
        return result;
    }

    @Benchmark
    public long sequentialStreamSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(ONE_HUNDRED_THOUSAND)
                .reduce(0L, Long::sum);
    }

    /**
     * 装箱和拆箱引入了很大的开销
     *
     * @return long
     */
    @Benchmark
    public long parallelStreamSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(ONE_HUNDRED_THOUSAND)
                .parallel()
                .reduce(0L, Long::sum);
    }

    @Benchmark
    public static long sequentialLongStreamSum() {
        return LongStream.rangeClosed(1, ONE_HUNDRED_THOUSAND)
                .sum();
    }

    @Benchmark
    public static long parallelLongStreamSum() {
        return LongStream.rangeClosed(1, ONE_HUNDRED_THOUSAND)
                .parallel()
                .sum();
    }
}
