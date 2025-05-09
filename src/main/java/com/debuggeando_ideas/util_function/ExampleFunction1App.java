package com.debuggeando_ideas.util_function;

import java.util.function.Function;

public class ExampleFunction1App {
    public static void main(String[] args) {
        System.out.println(multiply.apply(5));
        System.out.println(sum.apply(5));

        System.out.println(multiplyAndThen.apply(5));
        System.out.println(multiplyCompose.apply(5));
    }

    static Function<Integer, Integer> multiply = n -> n * 10;
    static Function<Integer, Integer> sum = n -> n + 10;
    static Function<Integer, Integer> multiplyAndThen = multiply.andThen(sum);
    static Function<Integer, Integer> multiplyCompose = multiply.compose(sum);
}
