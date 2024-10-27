package old.chapter4;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindingAndMatching {

    public static void main(String... args) throws IOException {
        // Find and Matching Operation
        System.out.println("******** Filter Operation ************");
        List<Dish> menu = Dish.menu;

        if (menu.stream().anyMatch(dish -> dish.isVegetarian())) {
            System.out.println("yo");
        }

        boolean result = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(result);

        boolean isHealthy = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
        System.out.println(isHealthy);
        menu.stream().filter(dish -> dish.isVegetarian()).collect(Collectors.toList());

        Optional<Dish> dish =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();

        System.out.println("If Present demo ");
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny().ifPresent(dish1 -> System.out.println(dish1));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0).findFirst();

        System.out.println(firstSquareDivisibleByThree.get());

    }
}
