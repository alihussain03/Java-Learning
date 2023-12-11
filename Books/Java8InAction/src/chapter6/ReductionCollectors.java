package chapter6;

import chapter4And5.Dish;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReductionCollectors {

  public static void main(String[] args) {
    List<Dish> menu = Dish.menu;

    Long collect = menu.stream().collect(Collectors.counting());
    System.out.println(collect);

    Optional<Dish> mostCalorieDish = menu.stream()
        .collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));

    int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
    double averageCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
    IntSummaryStatistics menuStatistics = menu.stream()
        .collect(Collectors.summarizingInt(Dish::getCalories));

    System.out.println(menuStatistics);

    String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
    System.out.println(shortMenu);
  }
}
