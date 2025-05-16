package com.debuggeando_ideas.util;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class Movie {
    private String title;
    private String year;
    private Double price;

    public Optional<String> getTitle() {
        return Optional.of(this.title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Optional<String> getYear() {
        return Optional.of(this.year);
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Optional<Double> getPrice() {
        return Optional.of(this.price);
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
