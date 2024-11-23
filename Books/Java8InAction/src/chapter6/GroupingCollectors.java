package chapter6;

import chapter4And5.pojo.Dish;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static chapter4And5.pojo.Dish.dishTags;
import static chapter4And5.pojo.Dish.menu;
import static java.util.stream.Collectors.*;


public class GroupingCollectors {

    enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String... args) {
        System.out.println("Dishes grouped by type: " + groupDishesByType() + "\n");
        System.out.println("Dishes grouped by caloric level: " + groupDishesByCaloricLevel() + "\n");
        System.out.println("Dish tags grouped by type: " + groupAndFilterDishesByCaloric() + "\n");
        System.out.println("Dish names grouped by type: " + groupDishNamesByType() + "\n");
        System.out.println("Caloric dishes grouped by type: " + groupDishTagsByType() + "\n");

        System.out.println("Dishes grouped by type and caloric level: " + groupDishedByTypeAndCaloricLevel() + "\n");
        System.out.println("Count dishes in groups: " + countDishesInGroups() + "\n");
        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByType() + "\n");
        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByTypeWithoutOptionals() + "\n");
        System.out.println("Sum calories by type: " + sumCaloriesByType() + "\n");
        System.out.println("Caloric levels by type: " + caloricLevelsByType() + "\n");
    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream().collect(groupingBy(Dish::getType));
    }

    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }));
    }

    // Manipulating group elements
    private static Map<Dish.Type, List<Dish>> groupAndFilterDishesByCaloric() {
        return menu.stream().collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
    }


    private static Map<Dish.Type, List<String>> groupDishNamesByType() {
        return menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
    }

    private static Map<Dish.Type, Set<String>> groupDishTagsByType() {
        return menu.stream().collect(groupingBy(Dish::getType, flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));
    }

    private static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return menu.stream().collect(groupingBy(Dish::getType, groupingBy((Dish dish) -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        })));
    }

    //counting data in subgroups
    private static Map<Dish.Type, Long> countDishesInGroups() {
        return menu.stream().collect(groupingBy(Dish::getType, counting()));
    }

    private static Map<Dish.Type, Optional<Dish>> mostCaloricDishesByType() {
        return menu.stream().collect(groupingBy(Dish::getType, reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)));
    }

    private static Map<Dish.Type, Dish> mostCaloricDishesByTypeWithoutOptionals() {
        return menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2), Optional::get)));
    }

    private static Map<Dish.Type, Integer> sumCaloriesByType() {
        return menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
    }

    private static Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType() {
        return menu.stream().collect(groupingBy(Dish::getType, mapping(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }, toSet())));
    }
}
