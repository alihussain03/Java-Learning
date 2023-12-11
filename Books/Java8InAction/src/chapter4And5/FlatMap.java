package chapter4And5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class FlatMap {

  public static void main(String[] args) {
    String[] words = {"Hello", " World"};

    List<String[]> collect = Arrays.stream(words).map(s -> s.split("")).distinct()
        .collect(toList());
    System.out.println(collect.size());

    List<String> uniqueCharacters = Arrays.stream(words).map(s -> s.split(""))
        .flatMap(strings -> Arrays.stream(strings)).distinct().collect(toList());

    System.out.println(uniqueCharacters);

    // problem 2

    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> numbers2 = Arrays.asList(6, 7, 8);
    List<int[]> pairs = numbers1.stream()
        .flatMap((Integer i) -> numbers2.stream()
            .map((Integer j) -> new int[]{i, j})
        )
        .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
        .collect(toList());
    pairs.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));

    //problem 3

    List<int[]> collect1 = numbers1.stream()
        .flatMap(number1 -> numbers2.stream().map(number2 -> new int[]{number1, number2}))
        .collect(toList());

    collect1.forEach(ints -> Arrays.stream(ints).forEach(value -> System.out.println(value)));
  }
}
