package chapter4And5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SliceOperation {
    public static void main(String[] args) {

        List<Dish> specialMenu = Arrays.asList(new Dish("Seasonal Fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("Rice", true, 350, Dish.Type.OTHER),
                new Dish("Chicken", false, 400, Dish.Type.MEAT));

        System.out.println("take all the dishes whose calories less to 320");
        specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("Drop all the dishes whose calories less than 320");
        specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("Limit operation");
        specialMenu.stream().filter(dish -> dish.getCalories() > 300).limit(3).forEach(System.out::println);

        System.out.println("Skipping operation");
        specialMenu.stream().filter(dish -> dish.getCalories() > 300).skip(1).forEach(System.out::println);

    }
}
