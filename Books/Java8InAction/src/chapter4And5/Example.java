package chapter4And5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Example {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        menu.stream().filter(dish -> dish.getCalories() < 320).collect(Collectors.toList());

        List<Dish> dishes = menu.stream().filter(dish -> dish.getCalories() < 320).limit(3)
                .collect(Collectors.toList());

        List<Dish> skipDishes = menu.stream().filter(dish -> dish.getCalories() > 320).skip(3)
                .collect(Collectors.toList());

        if (menu.stream().anyMatch(dish -> dish.isVegetarian())) {
            System.out.println("Vegetarian");
        }

        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);

        boolean isNotHealthy = menu.stream().noneMatch(dish -> dish.getCalories() > 1000);
        System.out.println(isNotHealthy);

        Optional<Dish> isNotHealthy1 = menu.stream().filter(dish -> dish.isVegetarian()).findAny();
        System.out.println(isNotHealthy1.get().getName());

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDividedByThree = someNumbers.stream()
                .map(integer -> integer * integer)
                .filter(integer -> integer % 3 == 0).findFirst();

        System.out.println(firstSquareDividedByThree.get());
    }


}
