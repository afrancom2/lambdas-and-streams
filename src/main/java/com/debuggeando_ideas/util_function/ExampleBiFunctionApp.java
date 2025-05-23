package com.debuggeando_ideas.util_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class ExampleBiFunctionApp {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 2);

        List<String> result = listCombiner(list1, list2, (l1, l2)-> l1 + l2);
        System.out.println(result);
    }

    private static <T,U,R> List<R> listCombiner(List<T> list1, List<U> list2, BiFunction<T,U,R> combiner) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }
}
