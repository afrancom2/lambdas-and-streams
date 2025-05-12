package com.debuggeando_ideas.pallalel_streams;

import java.util.List;

public class ExampleApp {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C", "D", "E", "F", "G");

        // Usando parallelStream + filter
        String resultFindFirst = list.parallelStream()
                .filter(s -> {
                    System.out.println("filtering (findFirst): " + s + " - " + Thread.currentThread().getName());
                    return s.compareTo("C") > 0; // D, E, F, G
                })
                .findFirst()
                .orElse("No match");

        String resultFindAny = list.parallelStream()
                .filter(s -> {
                    System.out.println("filtering (findAny): " + s + " - " + Thread.currentThread().getName());
                    return s.compareTo("C") > 0; // D, E, F, G
                })
                .findAny()
                .orElse("No match");

        System.out.println("\nResult using findFirst(): " + resultFindFirst);
        System.out.println("Result using findAny(): " + resultFindAny);
    }
}
