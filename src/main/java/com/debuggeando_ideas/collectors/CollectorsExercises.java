package com.debuggeando_ideas.collectors;

import com.debuggeando_ideas.util.Console;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Review;
import com.debuggeando_ideas.util.Videogame;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExercises {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        //getReviews(videogames).forEach(System.out::println);
        //getWebSites(videogames).forEach((aBoolean, videogame) -> System.out.println(aBoolean + ": " + videogame));;
        getConsolesPricesAvg(videogames).forEach((k, v) -> System.out.println(k + " - " + v));
    }

    /*
     *Regresar una lista inmutable con todos los reviews del stream.
     */
    static Set<Review> getReviews(Stream<Videogame> stream) {
        return stream
                .flatMap(videogame -> videogame.getReviews().stream())
                .collect(Collectors.toUnmodifiableSet());
    }

    /*
     * Regresar un mapa true con todos los videojuegos que tengan una url(website) con una longitud menor a 15
     *  de lo contrario regresar false con una lista de los videojuegos que no cumplan la condicion.
     */
    static Map<Boolean, List<Videogame>> getWebSites(Stream<Videogame> stream) {
        return stream.collect(Collectors.partitioningBy(
                videogame -> videogame.getOfficialWebsite().length() < 15
        ));
    }

    /*
     *  Regresar en un mapa el promedio de ventas todas las consolas
     *  la clave del mapa será la consola y el valor el promedio de ventas.
     */
    static Map<Console, Double> getConsolesPricesAvg(Stream<Videogame> stream) {
        return stream.collect(Collectors.groupingBy(Videogame::getConsole, Collectors.averagingDouble(Videogame::getTotalSold)));
    }
}
