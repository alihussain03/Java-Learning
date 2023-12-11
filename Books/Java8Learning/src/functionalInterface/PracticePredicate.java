package functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PracticePredicate {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>();

    list.add("Basics");
    list.add("");
    list.add("Strong");
    list.add("");
    list.add("BasicsStrong");

    Predicate<String> predicate = s -> !s.isEmpty();
    List<String> newList = filterList(list, predicate);

    System.out.println(newList);

    Predicate<String> filter = s -> s.contains("Basics");
    System.out.println(filterList(list, filter));

//    List<Integer> intList = List.of(1,4,6,7,8);

    List<Integer> intList = new ArrayList<>();
    intList.add(1);
    intList.add(4);
    intList.add(5);
    intList.add(6);
    intList.add(8);

    Predicate<Integer> integerFilter = e -> e % 2 == 0;

    List<Integer> evens = filterList(intList, integerFilter);

    System.out.println(newList);

    System.out.println(evens);

  }

  private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {

    List<T> newList = new ArrayList<>();

    for (T string : list) {
      if (predicate.test(string)) {
        newList.add(string);
      }

    }
    return newList;
  }
}
