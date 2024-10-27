package chapter3.lambda.predefinedfunctionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorPractice {

    public static void main(String[] arg) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        UnaryOperator<Integer> unaryOperator = integer -> integer * 100;
        System.out.println(filterUsingGenerics(intList, unaryOperator));

    }

    static <T> List<T> filterUsingGenerics(List<T> listString, UnaryOperator<T> unaryOperator) {
        List<T> testString2 = new ArrayList<>();

        listString.forEach(s -> {
            testString2.add(unaryOperator.apply(s));
        });
        return testString2;
    }

}
