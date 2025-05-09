package com.debuggeando_ideas.util_function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ExampleBinaryOperatorApp {
    public static void main(String[] args) {
        BinaryOperator<String> normalizerFunction = (a, b) -> a.toUpperCase() + " - " + b.toLowerCase();
        System.out.println(normalizerFunction.apply("hola", "mundo"));

        System.out.println(addition.apply(10, 20));
    }

    static BinaryOperator<Integer> addition = (a, b) -> a + b;
}
