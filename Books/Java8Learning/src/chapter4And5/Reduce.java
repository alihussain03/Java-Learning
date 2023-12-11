package chapter4And5;

import java.util.Arrays;
import java.util.List;

public class Reduce {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    Integer sum = numbers.stream().reduce(0, (integer, integer2) -> integer + integer2);
    System.out.println(sum);

    Integer sumUsingMethodReference = numbers.stream().reduce(0, Integer::sum);
    System.out.println(sumUsingMethodReference);

    Integer maxUsingMethodReference = numbers.stream().reduce(0, Integer::max);
    System.out.println(maxUsingMethodReference);

    Integer minUsingMethodReference = numbers.stream().reduce(0, Integer::min);
    System.out.println(minUsingMethodReference);
  }
}
