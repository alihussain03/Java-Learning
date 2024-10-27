package chapter3;

import chapter2.Apple;
import chapter2.Color;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {

    public static void main(String arg[]) {
        Supplier<Apple> supplier = () -> new Apple(12, Color.GREEN);
        supplier.get();

        BiFunction<Integer, Color, Apple> function = Apple::new;
        System.out.println(function.apply(12, Color.RED));

    }
}
