package chapter4And5;

import chapter4And5.pojo.Dish;

import java.util.Arrays;
import java.util.List;

// reduce operation is a terminal operation in streams that allows you to combine elements of a stream to produce a single result
public class Operations_Reduce {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Integer sumUsingMethodReference = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum of array is : " + sumUsingMethodReference);

        Integer maxUsingMethodReference = numbers.stream().reduce(0, Integer::max);
        System.out.println("Max element of array is : " + maxUsingMethodReference);

        Integer minUsingMethodReference = numbers.stream().reduce(0, Integer::min);
        System.out.println("Min element of array is : " + minUsingMethodReference);

        int count = Dish.menu.stream().map(d -> 1).reduce(0, Integer::sum);
        System.out.println("count of dishes using Map and reduce is : " + count);
    }
}
