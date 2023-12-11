package old.chapter4;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapping {

  public static void main(String... args) throws IOException {
    // Filter Operation
    System.out.println("******** Stream Mapping ************");
    List<Dish> menu = Dish.menu;
    menu.stream().filter(dish -> dish.isVegetarian()).collect(Collectors.toList());
    List<String> dishesNameOnly = menu.stream().map(Dish::getName).collect(Collectors.toList());
    dishesNameOnly.forEach(System.out::println);

    System.out.println();
    List<Integer> dishesNameLength = menu.stream().map(dish -> dish.getName().length())
        .collect(Collectors.toList());
    dishesNameLength.forEach(System.out::println);

    System.out.println();
    List<Integer> dishesNameLength2 = menu.stream().map(Dish::getName).map(String::length)
        .collect(Collectors.toList());
    dishesNameLength2.forEach(System.out::println);

    System.out.println();
    List<String> listOfCharacter = Arrays.asList("Hello, World");
    List<Stream<String>> listOfCharacters = listOfCharacter.stream().map(word -> word.split(""))
        .map(Arrays::stream).distinct()
        .collect(Collectors.toList());
    listOfCharacters.forEach(System.out::println);

    System.out.println();
    List<String[]> listOfCharacters1 = listOfCharacter.stream().map(word -> word.split(""))
        .collect(Collectors.toList());
    System.out.println(listOfCharacters1.get(0)[1]);

    System.out.println();
    List<String> listOfCharacters2 = listOfCharacter.stream().map(word -> word.split(""))
        .flatMap(Arrays::stream)
        .collect(Collectors.toList());
    System.out.println(listOfCharacters2.size());

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> squares = numbers.stream().map(integer -> integer * integer)
        .collect(Collectors.toList());

    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(3, 4);

    List<int[]> fd = numbers1.stream().flatMap(integer ->
        numbers2.stream().map(integer1 -> new int[]{integer, integer1})
    ).collect(Collectors.toList());
  }
}
