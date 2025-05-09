package com.debuggeando_ideas.util_function;

import java.util.function.BiPredicate;

public class ExampleBiPredicateApp {
    public static void main(String[] args) {
        String s1 = "hello", s2 = "world";
        System.out.println(myEquals.test(s1, s2));
    }

    static BiPredicate<String, String> myEquals = (s1, s2) -> s1.concat(s2).equals("helloworld");
}
