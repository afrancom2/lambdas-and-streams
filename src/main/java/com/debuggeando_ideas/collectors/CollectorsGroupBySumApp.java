package com.debuggeando_ideas.collectors;

import com.debuggeando_ideas.util.Console;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsGroupBySumApp {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        Map<Console, IntSummaryStatistics> consoleIntegerMap = videogames
                .collect(Collectors.groupingBy(Videogame::getConsole, Collectors.summarizingInt(Videogame::getTotalSold)));

        consoleIntegerMap.forEach((key, value) -> System.out.println(key + ": " + value.getSum()));
    }
}
