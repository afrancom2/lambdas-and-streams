package com.debuggeando_ideas.real_appplications;

@FunctionalInterface
public interface ApplyDiscountStrategy {
    Double get(Double price);
}
