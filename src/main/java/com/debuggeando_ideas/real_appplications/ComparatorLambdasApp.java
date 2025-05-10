package com.debuggeando_ideas.real_appplications;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdasApp {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 2, 33, 1, 5, 3, 7, 4, 90, 10);

        numbers.sort((a, b) -> a - b);
        System.out.println(numbers);

        List<String> names = Arrays.asList("Max", "Alex", "Opal", "Coky");
        names.sort(String::compareTo);
        System.out.println(names);
        names.sort(Comparator.reverseOrder());
        System.out.println(names);


        List<Person> persons = Arrays.asList(new Person("Robert", 31), new Person("Jane", 32), new Person("Mary", 27), new Person("Bob", 10), new Person("Coky", 10));
        persons.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        System.out.println(persons);
    }
}
