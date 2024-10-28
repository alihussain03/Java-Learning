package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Java8");
        list.add("Reactive Java");

        // Type 1: Reference to a static method
        Consumer<String> consumer = System.out::println;
        list.forEach(consumer);

        Supplier<Double> supplier = Math::random;
        System.out.println(supplier.get());

        // Type 2: Reference to an instance method of a particular object
        BiFunction<String, String, String> biFunction = Test::concatString;
        System.out.println(biFunction.apply("Hello", "World"));

        // Type 3: Reference to an instance method of an arbitrary object of a particular type
        Function<String, Integer> function = String::length;
        System.out.println(function.apply("Hello"));
    }
}

class Test {
    static String concatString(String a, String b) {
        return a + " " + b;
    }
}