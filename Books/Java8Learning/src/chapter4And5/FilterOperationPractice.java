package chapter4And5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterOperationPractice {

  public static void main(String arg[]) {
    Stream.of(21, 378, 43, 22, 88).filter(number -> number % 2 == 0).forEach(System.out::println);

    List<Integer> collect = Stream.of(12, 343, 567, 121, 34564, 354235)
        .filter(integer -> integer == 21)
        .collect(Collectors.toList());

    collect.forEach(System.out::println);
  }
}
