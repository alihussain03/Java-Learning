package old.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberStreamsPractice {

  public static void main(String arg[]) {
    List<Book> books = new ArrayList<>();

    books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
    books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
    books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
    books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));

    OptionalDouble averageUsingMethod1 = books.stream().map(book -> book.getRating())
        .mapToDouble(value -> value).average();
    System.out.println(averageUsingMethod1.getAsDouble());

    OptionalDouble averageUsingMethod2 = books.stream().mapToDouble(value -> value.getRating())
        .average();
    System.out.println(averageUsingMethod2);

    IntStream intStream = IntStream.of(12, 13, 14);
    System.out.println(intStream.mapToObj(value -> value).count());

    System.out.println("Sum is " + IntStream.of(12, 13, 14).sum());

    System.out.println("Max is " + IntStream.of(12, 13, 14).max().getAsInt());
    System.out.println("Min is " + IntStream.of(12, 13, 14).min().getAsInt());
    System.out.println("Summary Statistics are " + IntStream.of(12, 13, 14).summaryStatistics());

    Stream<Double> randomNumberStream = Stream.generate(Math::random);
    randomNumberStream.forEach(System.out::println);


  }

}
