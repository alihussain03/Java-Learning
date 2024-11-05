package chapter4And5;

import chapter4And5.pojo.Book;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;


public class BoundedStreams {

    public static void main(String[] args) {
        //1. stream() on a Collection
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(5);

        Stream<Integer> streamIntegers = list.stream();

        //How we can stream a Map.
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(5, "four");

        Stream<Entry<Integer, String>> entries = map.entrySet().stream();

        Stream<String> values = map.values().stream();
        Stream<Integer> keys = map.keySet().stream();

        //2. of() Stream class

        Stream<String> streamStrings = Stream.of("Hey! ", "Happy", "Thanksgiving");

        //3. stream() of Arrays Class

        Integer[] integerArr = {3, 5, 7, 89, 9};
        Stream<Integer> stream = Arrays.stream(integerArr);

        int[] intArr = {3, 5, 7, 89, 9};
        IntStream stream2 = Arrays.stream(intArr);

        //4. builder() of Stream class.

        Builder<Integer> builder = Stream.builder();

        builder.add(1);

        //code

        //condition

        builder.add(4);

        builder.build();


    }

    public static class NumberStreamsPractice {

        public static void main(String[] arg) {
            List<Book> books = new ArrayList<>();

            books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
            books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
            books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
            books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));

            OptionalDouble averageUsingMethod1 = books.stream().map(Book::getRating)
                    .mapToDouble(value -> value).average();
            System.out.println(averageUsingMethod1.getAsDouble());

            OptionalDouble averageUsingMethod2 = books.stream().mapToDouble(Book::getRating)
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
}
