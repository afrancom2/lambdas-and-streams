package com.debuggeando_ideas.util_function;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class ExampleUnaryOperatorApp {
    public static void main(String[] args) {
        String argument = "lambdas-and-streams";
        System.out.println(functionToUpper.apply(argument));
        System.out.println(unaryOperator.apply(argument));
        System.out.println(intUnaryOperator.applyAsInt(5));
    }

    static Function<String, String> functionToUpper = String::toUpperCase;
    static UnaryOperator<String> unaryOperator = String::toUpperCase;
    static IntUnaryOperator intUnaryOperator = number -> number * number;
}
