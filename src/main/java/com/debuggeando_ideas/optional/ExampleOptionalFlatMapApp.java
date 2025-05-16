package com.debuggeando_ideas.optional;

import com.debuggeando_ideas.util.Movie;

import java.util.Optional;

public class ExampleOptionalFlatMapApp {
    public static void main(String[] args) {
        Movie movie = new Movie("star wars", "2000", 20.0);
        Optional<Movie> movieOptional = Optional.of(movie);

        String movieName = movieOptional.flatMap(Movie::getTitle).get();
        System.out.println(movieName);
    }
}
