package functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PracticeFunction {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>();

    list.add("Basics");
    list.add("");
    list.add("Strong");
    list.add("");
    list.add("BasicsStrong");

 //   Function<String, Integer> function = s -> s.length();
    Function<String, Integer> function = String :: length ;
    List<Integer> newList = map(list, function);
    System.out.println(newList);
  }

  private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
    List<R> newList = new ArrayList<>();
    for (T e : list) {
      newList.add(function.apply(e));
    }
    return newList;
  }
}
