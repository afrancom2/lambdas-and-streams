package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ConstructorsStreamsApp {
    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();
        videogameStream.forEach(System.out::println);

        System.out.println("-----Arreglo tradicional------");
        Integer[] myArrayNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stream<Integer> myStream = Arrays.stream(myArrayNumbers);
        myStream.forEach(System.out::println);

        System.out.println("-----Forma literal------");
        Stream.of("Hola", "mundo").forEach(System.out::println);

        System.out.println("-----Forma literal Double------");
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);
        doubleStream.forEach(System.out::println);
    }
}
