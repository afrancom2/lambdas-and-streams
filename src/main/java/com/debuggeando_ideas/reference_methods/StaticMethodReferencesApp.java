package com.debuggeando_ideas.reference_methods;

import java.util.UUID;
import java.util.function.Supplier;

public class StaticMethodReferencesApp {
    public static void main(String[] args) {
        //Supplier<UUID> getToken = () -> UUID.randomUUID();

        //Metodo estatico referenciado
        Supplier<UUID> getToken = UUID::randomUUID;
        System.out.println(getToken.get());
    }
}
