package chapter4And5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterOperation {
    public static void main(String[] args) {

        List<Dish> vegetarianDished = Dish.menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        vegetarianDished.forEach(System.out::println);

        // Filtering unique elements
        System.out.println("Filtering unique elements");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(integer -> integer % 2 == 0).distinct().forEach(System.out::println);

        System.out.println("Using Stream of ");
        List<Integer> collect = Stream.of(12, 343, 567, 121, 34564, 354235)
                .filter(integer -> integer == 12)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
