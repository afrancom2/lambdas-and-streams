package com.debuggeando_ideas.real_appplications;

public class Strategies {
    static ApplyDiscountStrategy basicDiscount = price -> price * 0.2;
    static ApplyDiscountStrategy plusDiscount = price -> price * 0.5;
    static ApplyDiscountStrategy primeDiscount = price -> price * 0.9;
}
