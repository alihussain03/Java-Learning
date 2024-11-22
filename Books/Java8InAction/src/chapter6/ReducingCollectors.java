package chapter6;

import chapter4And5.pojo.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReducingCollectors {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        Long collect = menu.stream().collect(Collectors.counting());
        System.out.println("Number of dishes using Collectors.counting(): " + collect);

        Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println("Most calories dish: " + (mostCalorieDish.isPresent() ? mostCalorieDish.get() : "No dish found"));
    }
}
