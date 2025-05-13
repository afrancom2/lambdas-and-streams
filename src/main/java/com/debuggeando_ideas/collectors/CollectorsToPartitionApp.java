package com.debuggeando_ideas.collectors;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsToPartitionApp {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        Map<Boolean, List<Videogame>> result = videogames.collect(Collectors.partitioningBy(
                videogame -> videogame.getPrice() > 15
        ));
        result.get(true).forEach(System.out::println);
        System.out.println("-----------------------");
        result.get(false).forEach(System.out::println);
        System.out.println("-----------------------");
        result.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
}
