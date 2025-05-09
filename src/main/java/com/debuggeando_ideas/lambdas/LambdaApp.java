package com.debuggeando_ideas.lambdas;

public class LambdaApp {
    public static void main(String[] args) {
        Math substract = new Math() {
            @Override
            public Double execute(Double a, Double b) {
                return a - b;
            }
        };
        System.out.println(substract.execute(50.0, 5.0));

        Math multiply = (a, b) -> a * b;
        System.out.println(multiply.execute(50.0, 5.0));
        System.out.println(multiply.sum(50.0, 5.0));

        Math divide = (a, b) -> {
            System.out.println("Start");
            return a / b;
        };
        System.out.println(divide.execute(50.0, 5.0));


    }
}
