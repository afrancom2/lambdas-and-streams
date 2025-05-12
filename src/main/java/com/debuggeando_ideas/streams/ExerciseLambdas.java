package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Console;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Review;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciseLambdas {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        exercise5(videogames).forEach(System.out::println);
        //exercise5(videogames);
    }

    /*
     *Regresar true si el stream contiene al menos un videojuego con número de ventas mayor a 10
     * y no este en descuento o su precio sea mayor a 9.99 de lo contrario regresar false.
     */
    static Boolean exercise1(Stream<Videogame> stream) {
        List<Videogame> result = stream
                .filter(videogame -> videogame.getTotalSold() > 10)
                .filter(videogame -> !videogame.getIsDiscount())
                .collect(Collectors.toList());

        return result.stream().anyMatch(videogame -> videogame.getPrice() > 9.99);
    }

    /*
     *Regresar un Stream unicamente con los titulos de todas las consolas que sean de XBOX
     * durante el proceso imprimir los resultados ignorando los repetidos.
     */
    static Stream<String> exercise2(Stream<Videogame> stream) {
        return stream
                .filter(videogame -> videogame.getConsole().name().contains(Console.XBOX.name()))
                .distinct()
                .map(Videogame::getName)
                .distinct();
    }

    /*
     *Regresar el videojuego con el mayor número de ventas
     * unicamente contemplando los primers 10 elementos del stream.
     */
    static Videogame exercise3(Stream<Videogame> stream) {
        return stream
                .limit(10)
                .max(Comparator.comparing(videogame -> videogame.getTotalSold())).get();
    }

    /*
     *Regresar un stream con todos los comentarios del cada review de todos los videojuegos del stream.
     */
    static Stream<String> exercise4(Stream<Videogame> stream) {
        Stream<Review> reviews = stream.flatMap(videogame -> videogame.getReviews().stream());
        return reviews.map(Review::getComment);
    }

    /*
     *Regresar un stream con los todos los videojuegos con precio menores a 20.0
     * sin utilizar el operador filter().
     */
    static Stream<Videogame> exercise5(Stream<Videogame> stream) {
        return stream
                .flatMap(videogame -> videogame.getPrice() < 20.0 ? Stream.of(videogame) : Stream.empty());
    }

}
