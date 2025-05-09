package com.debuggeando_ideas.util_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ExamplePredicateApp {
    public static void main(String[] args) {
        List<Integer> number = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        number.removeIf(isBetweenFiveAndSeven.negate());
        System.out.println(number);
    }

    static Predicate<Integer> isGreaterThanSeven = num -> num > 7;
    static Predicate<Integer> isLessThanFive = num -> num < 5;
    static Predicate<Integer> isBetweenFiveAndSeven = isGreaterThanSeven.or(isLessThanFive);
}
