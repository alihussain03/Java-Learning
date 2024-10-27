package old.chapter4;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {

    public static void main(String... args) throws IOException {
        List<Dish> menu = Dish.menu;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 5);
        Optional<Integer> sum = numbers.stream().reduce((integer, integer2) -> integer + integer2);
        System.out.println(sum.get());

        Integer sum1 = numbers.stream().reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println(sum1);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        int sum2 = numbers.stream().reduce(0, Integer::sum);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        long count = menu.stream().count();


    }
}
