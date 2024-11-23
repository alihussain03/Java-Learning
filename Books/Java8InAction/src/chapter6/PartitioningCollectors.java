package chapter6;

import chapter4And5.pojo.Dish;
import chapter4And5.pojo.Dish.Type;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static chapter4And5.pojo.Dish.menu;
import static java.util.stream.Collectors.*;

public class PartitioningCollectors {

    public static void main(String... args) {
        Map<Boolean, List<Dish>> menu = partitionByVegetarian();
        System.out.println("Partition Menu : " + partitionByVegetarian() + "\n");
        System.out.println("Only Vegetarian: " + menu.get(true) + "\n");
        System.out.println("Partition Menu : " + partitionByVegetarian1() + "\n");
        System.out.println("Most Caloric dishes are : " + mostCaloricPartitionedByVegetarian());

    }

    private static Map<Boolean, List<Dish>> partitionByVegetarian() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian));
    }

    private static Map<Boolean, Map<Type, List<Dish>>> partitionByVegetarian1() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
    }

    private static Object mostCaloricPartitionedByVegetarian() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(
                Comparator.comparingInt(Dish::getCalories)), Optional::get)));
    }
}
