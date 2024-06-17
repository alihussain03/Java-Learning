package chapter6;

import static chapter4And5.Dish.menu;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;

import chapter4And5.Dish;
import chapter4And5.Dish.Type;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PartitioningCollectors {

  public static void main(String... args) {

  }

  private static Map<Boolean, List<Dish>> partitionByVegeterian() {
    return menu.stream().collect(partitioningBy(Dish::isVegetarian));
  }

  private static Map<Boolean, Map<Type, List<Dish>>> partitionByVegeterian1() {
    return menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
  }

  private static Object mostCaloricPartitionedByVegetarian() {
    return menu.stream().collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(
        Comparator.comparingInt(Dish::getCalories)), Optional::get)));
  }
}