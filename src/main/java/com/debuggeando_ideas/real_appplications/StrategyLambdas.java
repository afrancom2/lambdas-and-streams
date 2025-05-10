package com.debuggeando_ideas.real_appplications;

import java.util.List;

public class StrategyLambdas {

    public static void main(String[] args) {
        Product productOne = Product.builder()
                .id(1L)
                .price(300.0)
                .name("coky")
                .userType("BASIC")
                .build();
        Product productTwo = Product.builder()
                .id(1L)
                .price(300.0)
                .name("coky")
                .userType("PLUS")
                .build();
        Product productThree = Product.builder()
                .id(1L)
                .price(300.0)
                .name("coky")
                .userType("PRIME")
                .build();
        List<Product> productList = List.of(productOne, productTwo, productThree);
        productList.forEach(product -> {
            switch (product.getUserType()) {
                case "BASIC": product.setDiscountStrategy(Strategies.basicDiscount); break;
                case "PLUS": product.setDiscountStrategy(Strategies.plusDiscount); break;
                case "PRIME": product.setDiscountStrategy(Strategies.primeDiscount); break;
            }
        });
        productList.forEach(product ->  {
            System.out.println("Price: " + product.getPrice() + " UserType: " + product.getUserType()
            + " DiscountStrategy: " + product.getDiscountStrategy().get(product.getPrice()));
        });
    }

}

