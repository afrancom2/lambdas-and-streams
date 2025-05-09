package com.debuggeando_ideas.reference_methods;

import java.util.function.BiPredicate;

public class ArbitraryMethodReferencesApp {
    public static void main(String[] args) {
        BiPredicate<String, String> equalsObjects = (s1, s2) -> s1.equals(s2);
        boolean isEquals = equalsObjects.test("hello", "world");
        System.out.println(isEquals);

        //Ahora con referencia arbitraria

        BiPredicate<String, String> equalsArbitrary = String::equals;
        boolean isArbitrary = equalsArbitrary.test("hello", "hello");
        System.out.println(isArbitrary);
    }
}
