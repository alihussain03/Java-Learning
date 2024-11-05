package chapter4And5;

import java.util.Arrays;
import java.util.List;

public class FindingAndMatchingOperation {
    public static void main(String[] args) {
        boolean isVegetarian = Dish.menu.stream().anyMatch(Dish::isVegetarian);
        System.out.println("Does it have any vegetation dish ? " + isVegetarian);

        boolean isHealthy = Dish.menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("Does it have all healthy dish ? " + isHealthy);

        isHealthy = Dish.menu.stream().noneMatch(dish -> dish.getCalories() < 1000);
        System.out.println("Does it have any dish have more than 1000 calories? " + isHealthy);

        System.out.println("Selected Dish ???");
        Dish.menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(dish1 -> System.out.println(dish1.getName()));

        System.out.println("Selected Dish ???");
        Dish.menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(dish1 -> System.out.println(dish1.getName()));

        System.out.println("Find First Demo:");
        List<Integer> someNumbers = Arrays.asList(2, 3, 4, 5, 6);
        someNumbers.stream().map(integer -> integer * integer).filter(integer -> integer % 3 == 0).findFirst().ifPresent(integer -> System.out.println(integer));

    }
}
