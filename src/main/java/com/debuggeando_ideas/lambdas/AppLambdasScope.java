package com.debuggeando_ideas.lambdas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AppLambdasScope {
    public static void main(String[] args) {
        //Asi se crear una variable para usarla en una parte concurrente
        AtomicInteger number = new AtomicInteger(10);

        IntStream.range(0, 10).forEach(i -> {
            number.set(number.get() + i);
            System.out.println(number);
        });

        System.out.println(number.get());

    }
}
