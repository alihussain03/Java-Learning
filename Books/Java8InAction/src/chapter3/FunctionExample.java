package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String arg[]) {

        List<String> name = new ArrayList<>();
        name.add("Hello World");
        name.add("Nokia");
        name.add("Hello World");
        name.add("Nokia");
        Function<String, Integer> function = s -> s.length();
        System.out.println(filterUsingGenerics(name, function));
    }

    static <T, R> List<R> filterUsingGenerics(List<T> listString, Function<T, R> function) {
        List<R> testString2 = new ArrayList<>();

        listString.forEach(s -> {

            testString2.add(function.apply(s));
        });
        return testString2;
    }
}
