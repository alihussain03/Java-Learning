package functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class PracticeUnaryFunction {

  public static void main(String[] args) {
    List<Integer> intList = new ArrayList<>();
    intList.add(1);
    intList.add(4);
    intList.add(5);
    intList.add(6);
    intList.add(8);

    UnaryOperator<Integer> operator = i -> i * 100;

    List<Integer> newList = mapper(intList, operator);

    System.out.println(newList);


  }

  private static <T> List<T> mapper(List<T> list, UnaryOperator<T> operator) {

    List<T> newList = new ArrayList<>();

    for (T t : list) {
      T ele = operator.apply(t);
      newList.add(ele);
    }
    return newList;
  }
}