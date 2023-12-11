package old.lambda.predefinedfunctionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorPractice {

  public static void main(String arg[]) {
  /*  List<Integer> intList = List.of(2, 1, 1, 6, 3, 8);

    UnaryOperator<Integer> unaryOperator = integer -> integer * 100;
    System.out.println(filterUsingGenerics(intList, unaryOperator));*/

  }

  static <T> List<T> filterUsingGenerics(List<T> listString, UnaryOperator<T> unaryOperator) {
    List<T> testString2 = new ArrayList<>();

    listString.forEach(s -> {
      testString2.add(unaryOperator.apply(s));
    });
    return testString2;
  }

}
