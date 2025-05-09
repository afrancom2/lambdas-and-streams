package com.debuggeando_ideas.util_function;

import java.util.Random;
import java.util.function.Supplier;

public class ExampleSupplierApp {
    public static void main(String[] args) {
        System.out.println(randomInteger.get());
        System.out.println(randomInteger.get());
        System.out.println(randomInteger.get());
        System.out.println(randomInteger.get());
        System.out.println(myProductSupplier.get());
    }

    static Supplier<Integer> randomInteger = () -> new Random().nextInt(100);
    static Supplier<MyProduct> myProductSupplier = () -> new MyProduct(100, "Coky");
}
