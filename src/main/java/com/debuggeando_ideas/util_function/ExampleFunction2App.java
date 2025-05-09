package com.debuggeando_ideas.util_function;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;

public class ExampleFunction2App {
    public static void main(String[] args) {
        ByteArrayOutputStream objectSerialized = serializer.apply(new Person("Coky", 11));
        System.out.println(Arrays.toString(objectSerialized.toByteArray()));

        Person objectDeserialized = deserializer.apply(new ByteArrayInputStream(objectSerialized.toByteArray()));
        System.out.println(objectDeserialized);
    }

    static Function<Person, ByteArrayOutputStream> serializer = p -> {
        ByteArrayOutputStream inMemoryBytes = new ByteArrayOutputStream();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(inMemoryBytes)) {
            outputStream.writeObject(p);
            outputStream.flush();
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
        return inMemoryBytes;
    };

    static Function<ByteArrayInputStream, Person> deserializer = bais -> {
        try (ObjectInputStream inputStream = new ObjectInputStream(bais)) {
            return (Person) inputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            System.err.println(exception.getMessage());
            throw new RuntimeException(exception);
        }
    };

}
