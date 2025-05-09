package com.debuggeando_ideas.util_function;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExampleConsumerApp {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> squares = new LinkedList<>();
        numbers.forEach(number -> squares.add(number * number));
        System.out.println(squares);

        Map<Boolean, String> map = Map.of(true, "this is the truth", false, "this is the lie");

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
