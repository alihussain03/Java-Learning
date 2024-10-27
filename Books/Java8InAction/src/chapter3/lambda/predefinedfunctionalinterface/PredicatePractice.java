package chapter3.lambda.predefinedfunctionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicatePractice {

    public static void main(String[] arg) {
        List<String> listOfString = new ArrayList<>();
        listOfString.add("Hello World");
        listOfString.add("Nokia");
        listOfString.add("");
        listOfString.add("");
        listOfString.add("Hello World");
        listOfString.add("Nokia");

    /*Predicate<String> predicateForEmptyString = s1 -> !s1.isBlank();
    List<String> sortedList = filterSting(listOfString, predicateForEmptyString);
    List<String> sorted_list = filterUsingGenerics(listOfString, predicateForEmptyString);
    System.out.println(sortedList.size());
    System.out.println(sorted_list.size());

    Predicate<String> predicateForStringContains = s1 -> s1.contains("Nokia");
    List<String> sortedList2 = filterSting(listOfString, predicateForStringContains);

    List<Integer> intList = List.of(2, 1, 1, 6, 3, 8);
    Predicate<Integer> predicateForIntegerAndGenerics = s1 -> s1 % 2 == 0;
    List<Integer> sortedList3 = filterUsingGenerics(intList, predicateForIntegerAndGenerics);

    System.out.println(sortedList2.size());
    System.out.println(sortedList3.size());*/
    }

    static List<String> filterSting(List<String> listString, Predicate predicate) {
        List<String> testString2 = new ArrayList<>();

        listString.forEach(s -> {
            if (predicate.test(s)) {
                testString2.add(s);
            }
        });
        return testString2;
    }

    static <T> List<T> filterUsingGenerics(List<T> listString, Predicate<T> predicate) {
        List<T> testString2 = new ArrayList<>();

        listString.forEach(s -> {
            if (predicate.test(s)) {
                testString2.add(s);
            }
        });
        return testString2;
    }
}
