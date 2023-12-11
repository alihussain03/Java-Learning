package chapter4And5;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberStreams {

  public static void main(String... args) {

    List<Dish> menu = Dish.menu;

    IntStream intStream = menu.stream().mapToInt(value -> value.getCalories());
    Stream<Integer> boxed = intStream.boxed();

    OptionalInt maxCalories = menu.stream().mapToInt(value -> value.getCalories()).max();
    int max = maxCalories.orElse(1);

    IntStream intStream1 = IntStream.rangeClosed(1, 10).filter(value -> value % 2 == 0);
    //   intStream1.forEach(value -> System.out.println(value));

    IntStream evenNumbers = IntStream.rangeClosed(1, 100)
        .filter(n -> n % 2 == 0);
    System.out.println(evenNumbers.count());

    Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
        .flatMap(a -> IntStream.rangeClosed(a, 100)
            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
            .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
    pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    Stream<int[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
        .flatMap(a -> IntStream.rangeClosed(a, 100)
            .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
            .filter(t -> t[2] % 1 == 0))
        .map(array -> Arrays.stream(array).mapToInt(a -> (int) a).toArray());
    pythagoreanTriples2.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    //   Stream<Integer> integerStream = evenNumbers.mapToObj(value -> value);
    //  Stream<Integer> boxed1 = evenNumbers.boxed();

    IntStream.range(1, 3).mapToObj(Integer::valueOf)
        .map(Integer::shortValue)
        .forEach(System.out::print);
  }

  public static boolean isPerfectSquare(int n) {
    return Math.sqrt(n) % 1 == 0;
  }
}
