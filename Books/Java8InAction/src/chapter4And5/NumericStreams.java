package chapter4And5;

import chapter4And5.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {

    public static void main(String... args) {

        List<Dish> menu = Dish.menu;

        int calories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("Sum of all calories using int stream: " + calories);

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        // boxed is useful when you deal with numeric ranges that need to be boxed into a general stream
        Stream<Integer> boxed = intStream.boxed();

        //use of optional for max
        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
        int max = maxCalories.orElse(1);
        System.out.println("Max calories using int stream: " + max);

        System.out.println("Usage of rangeClosed static method: ");
        IntStream intStream1 = IntStream.rangeClosed(1, 10).filter(value -> value % 2 == 0);
        intStream1.forEach(System.out::println);

        System.out.println("Usage of range static method: ");
        IntStream intStream2 = IntStream.range(1, 10).filter(value -> value % 2 == 0);
        System.out.println(intStream2.count());

        System.out.println("Pythagorean Triples Method 1: ");
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        System.out.println("Pythagorean Triples Method 2: ");
        Stream<int[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0))
                .map(array -> Arrays.stream(array).mapToInt(a -> (int) a).toArray());
        pythagoreanTriples2.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));


        IntStream.range(1, 3).boxed()
                .map(Integer::shortValue)
                .forEach(System.out::print);
    }
}
