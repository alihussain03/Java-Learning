package old.chapter4;

import old.chapter4.Dish.Type;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {

  public static void main(String... args) throws IOException {

    // Filter Operation
    System.out.println("******** Filter Operation ************");
    List<Dish> menu = Dish.menu;
    menu.stream().filter(dish -> dish.isVegetarian()).collect(Collectors.toList());

    List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian)
        .collect(Collectors.toList());
    vegetarianDishes.forEach(System.out::println);

    List<Dish> meatDishes = menu.stream().filter(dish -> dish.getType()
            == Type.MEAT)
        .collect(Collectors.toList());
    meatDishes.forEach(System.out::println);

    //Distinct Operation
    System.out.println("******** Distinct Operation ************");
    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    List<Integer> evenDistinctnumbers = numbers.stream().filter(integer -> integer % 2 == 0)
        .distinct().collect(Collectors.toList());
    evenDistinctnumbers.forEach(System.out::println);

    //Limit Operation
    System.out.println("******** Limit Operation ************");
    List<Dish> dishesWithMoreCalories = menu.stream().filter(dish -> dish.getCalories() > 300)
        .limit(2)
        .collect(Collectors.toList());
    dishesWithMoreCalories.forEach(System.out::println);

    //Skip Elemeents
    System.out.println("******** Skip Operation ************");
    List<Dish> dishesWithMoreCaloriesSkipFirstTwo = menu.stream()
        .filter(dish -> dish.getCalories() > 300).skip(2)
        .collect(Collectors.toList());
    dishesWithMoreCaloriesSkipFirstTwo.forEach(System.out::println);


  }
}
