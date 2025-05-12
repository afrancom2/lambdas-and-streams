package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.BasicVideogame;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Review;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInterMediateOperatorsApp {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        System.out.println(videogames.count());
        distinctOperator(Database.videogames.stream());
        limitOperator(Database.videogames.stream());
        skipOperator(Database.videogames.stream());
        System.out.println("--------Filter-------");
        filterOperator(Database.videogames.stream());
        System.out.println("--------Map----------");
        mapOperator(Database.videogames.stream());
        System.out.println("--------FlatMap------");
        flatMapOperator(Database.videogames.stream());
        System.out.println("--------MapVSFlatMap-");
        mapVSflatMapOperator(Database.videogames.stream());
        System.out.println("--------Peek---------");
        //peekOperator(Database.videogames.stream());
        System.out.println("--------Sorted-------");
        sortOperator(Database.videogames.stream());
        System.out.println("--------TakeWhile----");
        takeWhileOperator(Database.videogames.stream());
        System.out.println("--------DropWhile----");
        dropWhileOperator(Database.videogames.stream());
    }

    static void distinctOperator(Stream<Videogame> videogames) {
        System.out.println(videogames.distinct().count());
    }

    static void limitOperator(Stream<Videogame> videogames) {
        Set<Videogame> result = videogames.limit(5).collect(Collectors.toSet());
        result.forEach(System.out::println);
    }

    static void skipOperator(Stream<Videogame> videogames) {
        videogames.skip(18).forEach(System.out::println);
    }

    static void filterOperator(Stream<Videogame> videogames) {
        videogames
                .filter(videogame -> videogame.getPrice() > 10)
                .filter(videogame -> videogame.getIsDiscount())
                .filter(videogame -> videogame.getOfficialWebsite().contains("forza"))
                .forEach(System.out::println);
    }

    static void mapOperator(Stream<Videogame> videogames) {
        Set<BasicVideogame> basicVideogames = videogames
                .map(videogame -> BasicVideogame.builder()
                        .name(videogame.getName())
                        .price(videogame.getPrice())
                        .console(videogame.getConsole())
                        .build()).collect(Collectors.toSet());

        List<String> titles = basicVideogames.stream()
                .map(BasicVideogame::getName)
                .collect(Collectors.toList());
        titles.forEach(System.out::println);
        basicVideogames.forEach(System.out::println);
    }

    static void flatMapOperator(Stream<Videogame> videogames) {
        List<Review> result = videogames.flatMap(videogame -> videogame.getReviews().stream()).collect(Collectors.toList());
        result.forEach(review -> System.out.println(review.getComment()));
    }

    static void mapVSflatMapOperator(Stream<Videogame> videogames) {
        //List<Integer> totalReviews = videogames.map(videogame -> videogame.getReviews().size()).collect(Collectors.toList());
        var totalReviews = videogames.flatMap(videogame -> videogame.getReviews().stream()).filter(review -> review.getScore()>3);
        totalReviews.forEach(System.out::println);
    }

    static void peekOperator(Stream<Videogame> videogames) {
        videogames.peek(video -> video.setName("")).forEach(System.out::println);
    }

    static void sortOperator(Stream<Videogame> videogames) {
        // Aca se orden por la cantidad de reviews que tenga, más no por el total de score de la review
        List<Videogame> result = videogames.sorted(Comparator.comparingInt(videogame -> videogame.getReviews().size())).collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    static void takeWhileOperator(Stream<Videogame> videogames) {
        List<Videogame> result = videogames
                .sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(videogame -> !videogame.getName().startsWith("M"))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    static void dropWhileOperator(Stream<Videogame> videogames) {
        List<Videogame> result = videogames
                .sorted(Comparator.comparing(Videogame::getName))
                .dropWhile(videogame -> videogame.getPrice()>10)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
