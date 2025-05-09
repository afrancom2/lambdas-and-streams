package com.debuggeando_ideas.lambdas;

import java.util.List;

public class AppCountriesMain {
    public static void main(String[] args) {
        List<String> countries = List.of("Mexico", "Colombia", "United Kingdom", "Chile", "Uruguay");

        for (String c: countries) {
            System.out.println(c);
        }

        countries.forEach(c -> System.out.println(c.toUpperCase()));
    }
}
