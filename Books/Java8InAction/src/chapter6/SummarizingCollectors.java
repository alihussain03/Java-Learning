package chapter6;

import chapter4And5.pojo.Dish;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SummarizingCollectors {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("Total Calories: " + totalCalories);

        double averageCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("Average Calories: " + averageCalories);

        IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("Menu Statistics: " + menuStatistics);

        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println("Join dished name using Collectors.joining(): " + shortMenu);
    }
}
