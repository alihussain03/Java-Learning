package chapter4And5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import chapter4And5.streams.Book;

public class MapOperationPractice {

  public static void main(String arg[]) {
    Stream.of(21, 378, 43, 22, 88).map(number -> number * 2).forEach(System.out::println);

    List<Book> books = new ArrayList<>();

    books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
    books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
    books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
    books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));

    books.stream()
        .filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
        .filter((book) -> book.getRating() > 3)
        .map(book -> book.getAuthor()).forEach(System.out::println);
  }

}
