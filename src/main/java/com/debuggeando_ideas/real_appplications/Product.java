package com.debuggeando_ideas.real_appplications;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Product {
    private Long id;
    private String name;
    private String userType;
    private Double price;
    private ApplyDiscountStrategy discountStrategy;
}
