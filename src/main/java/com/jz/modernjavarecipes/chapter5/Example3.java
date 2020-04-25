package com.jz.modernjavarecipes.chapter5;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 第n个斐波那契数 class
 * 利用缓存计算斐波那契数
 *
 * @author Jun Zhang
 * @date 24/04/2020
 */
public class Example3 {

    private static BigInteger fib(long i) {
        Map<Long, BigInteger> cache = new HashMap<>();
        switch ((int) i) {
            case 1:
                return BigInteger.ZERO;
            case 2:
                return BigInteger.ONE;
            default:
                return cache.computeIfAbsent(i, n -> fib(n - 2).add(fib(n - 1)));
        }
    }

    private static Map<String, Integer> wordCount(String passage, String... strings) {
        Map<String, Integer> map = new HashMap<>(16);
        Arrays.stream(strings).forEach(s -> map.put(s, 0));
        Arrays.stream(passage.split(" ")).forEach(word ->
                map.computeIfPresent(word, (k, v) -> v + 1));
        return map;
    }

    private static Map<String, Integer> fullWordCount(String passage, String... strings) {
        Map<String, Integer> map = new HashMap<>(16);
        Arrays.stream(passage.split(" ")).forEach(word ->
                map.merge(word, 1, Integer::sum));
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fib(4));

        String[] strings = {"this", "is", "a", "string"};
        String passage = "this is a string string list a string freak";
        Map<String, Integer> map = wordCount(passage, strings);
        // 更新特定单词出现的次数
        System.out.println(map);

        // 不存在的键返回空
        System.out.println(map.get("freak"));

        // 不存在的键返回默认值10
        System.out.println(map.getOrDefault("break", 10));

        Map<String, Integer> fullCountMap = fullWordCount(passage, strings);
        System.out.println(fullCountMap);
    }
}
