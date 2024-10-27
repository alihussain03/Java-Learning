package chapter3.lambda.predefinedfunctionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionPractice {

    public static void main(String[] arg) {


        List<String> name = new ArrayList<>();
        name.add("ali");
        name.add("hussain");
        name.add("Finland");
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
