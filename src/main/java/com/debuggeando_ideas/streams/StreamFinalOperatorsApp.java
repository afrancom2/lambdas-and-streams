package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinalOperatorsApp {
    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();
        countOperator(videogameStream);
        forEachOperator(Database.videogames.stream());
        anyMatchOperator(Database.videogames.stream());
        allMatchOperator(Database.videogames.stream());
        noneMatchOperator(Database.videogames.stream());
        findFirstOperator(Database.videogames.stream());
        findAnyOperator(Database.videogames.stream());
        reduceOperator(Database.videogames.stream());
        maxOperator(Database.videogames.stream());
        minOperator(Database.videogames.stream());
    }

    static void countOperator(Stream<Videogame> videogameStream) {
        System.out.println(videogameStream.count());
    }

    static void forEachOperator(Stream<Videogame> videogameStream) {
        videogameStream.forEach(System.out::println);
    }

    static void anyMatchOperator(Stream<Videogame> videogameStream) {
        boolean result = videogameStream.anyMatch(videogame -> videogame.getTotalSold() > 100);
        System.out.println(result);
    }

    static void allMatchOperator(Stream<Videogame> videogameStream) {
        boolean result = videogameStream.allMatch(videogame -> videogame.getTotalSold() > 10);
        System.out.println(result);
    }

    static void noneMatchOperator(Stream<Videogame> videogameStream) {
        boolean result = videogameStream.noneMatch(videogame -> videogame.getReviews().isEmpty());
        System.out.println(result);
    }

    static void findFirstOperator(Stream<Videogame> videogameStream) {
        Optional<Videogame> result = videogameStream.findFirst();
        System.out.println(result);
    }

    static void findAnyOperator(Stream<Videogame> videogameStream) {
        Optional<Videogame> result = videogameStream.findAny();
        System.out.println(result);
    }

    static void reduceOperator(Stream<Videogame> videogameStream) {
        Optional<Integer> result = videogameStream
                .filter(videogame -> !videogame.getIsDiscount())
                .map(Videogame::getTotalSold)
                .reduce(Integer::sum);
        System.out.println(result);
    }

    static void maxOperator(Stream<Videogame> videogameStream) {
        Optional<Videogame> result = videogameStream.max(Comparator.comparing(Videogame::getName));
        System.out.println(result.get().getName());
    }

    static void minOperator(Stream<Videogame> videogameStream) {
        Optional<Videogame> result = videogameStream.min(Comparator.comparing(Videogame::getPrice));
        System.out.println(result.get().getName());
    }
}
