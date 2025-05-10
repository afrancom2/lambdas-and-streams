package com.debuggeando_ideas.real_appplications;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ConcurrencyLambdas {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName());
        var execute = Executors.newSingleThreadExecutor();
        execute.submit(printerSum);

        var result = execute.submit(getSum);
        System.out.println("Result: " + result.get());
        execute.shutdown();
    }

    static Runnable printerSum = () -> {
        long sum = 0;
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
        System.out.println("total: " + sum);
    };

    static Callable<Long> getSum = () -> {
        long sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
        return sum;
    };
}

