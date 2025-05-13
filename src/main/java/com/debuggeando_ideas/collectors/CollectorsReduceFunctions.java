package com.debuggeando_ideas.collectors;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsReduceFunctions {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        avg(videogames);
        sum(Database.videogames.stream());
    }

    static void avg(Stream<Videogame> videogames) {
        Double avg = videogames.collect(Collectors.averagingDouble(Videogame::getPrice));
        System.out.println(avg);
    }

    static void sum(Stream<Videogame> videogames) {
        IntSummaryStatistics summaryStatistics = videogames.collect(Collectors.summarizingInt(videogame -> videogame.getReviews().size()));
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getAverage());
    }

    static void join(Stream<Videogame> videogames) {
        String stringGames = videogames
                .,a;
    }
}
