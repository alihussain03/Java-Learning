package chapter4And5;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStream {

  public static void main(String[] args) {
    Stream.iterate(0, integer -> integer + 2).limit(10).forEach(System.out::println);

    Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]}).limit(20)
        .forEach(ints -> System.out.println(ints[0] + "," + ints[1]));

    IntStream.iterate(0, operand -> operand + 4).filter(value -> value < 100).limit(10)
        .forEach(value -> System.out.println(value));

    Stream.generate(() -> Math.random()).limit(5).forEach(value -> System.out.println(value));

    Stream.generate(() -> new IntSupplier() {
      @Override
      public int getAsInt() {
        return 3;
      }
    }).limit(5).forEach(value -> System.out.println(value.getAsInt()));

  }
}
