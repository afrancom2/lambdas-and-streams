package com.debuggeando_ideas.optional;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Optional;

public class ExampleOptionalApp {
    public static void main(String[] args) {
        Optional<Videogame> gtaOptional = Database.videogames.stream().filter(videogame -> videogame.getName().toLowerCase().contains("gta")).findFirst();
        System.out.println(gtaOptional.orElseThrow(RuntimeException::new));
    }
}
