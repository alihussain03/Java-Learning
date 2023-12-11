package chapter3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

  public static void main(String arg[]) throws IOException {
    List<String> listOfString = new ArrayList<>();
    listOfString.add("Hello World");
    listOfString.add("Nokia");
    listOfString.add("");
    listOfString.add("");
    listOfString.add("Hello World");
    listOfString.add("Nokia");

    Predicate<String> predicateForEmptyString = s1 -> !s1.isEmpty();
    List<String> sortedList = filterSting(listOfString, predicateForEmptyString);
    System.out.println(sortedList.size());


    Predicate<String> predicateForStringContains = s1 -> s1.contains("Nokia");
    List<String> sorted_list = filterUsingGenerics(listOfString, predicateForStringContains);
    System.out.println(sorted_list.size());

    Predicate<String> combinePredicate = predicateForEmptyString.or(predicateForStringContains);

    List<String> sorted_list1 = filterUsingGenerics(listOfString, combinePredicate);
    System.out.println("Final Size is " + sorted_list1.size());

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
