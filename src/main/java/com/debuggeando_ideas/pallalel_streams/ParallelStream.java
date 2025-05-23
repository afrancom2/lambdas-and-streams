package com.debuggeando_ideas.pallalel_streams;

import java.util.List;

public class ParallelStream {

    //-D java.util.concurrent.ForkJoinPool.common.parallelism=5
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.parallelStream().forEach(number -> System.out.println(number + " - " + Thread.currentThread().getName()));
    }
}
