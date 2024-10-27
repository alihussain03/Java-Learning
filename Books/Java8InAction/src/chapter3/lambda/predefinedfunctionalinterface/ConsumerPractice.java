package chapter3.lambda.predefinedfunctionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice {

  public static void main(String[] args) {

    List<Integer> intList = new ArrayList<>();
    intList.add(1);
    intList.add(4);
    intList.add(5);
    intList.add(6);
    intList.add(8);

//    Consumer<Integer> consumer = integer -> System.out.println(integer);
    Consumer<Integer> consumer = System.out :: println ;

    consumer.accept(56);

    printElements(intList, consumer);


  }

  private static <T> void printElements(List<T> list, Consumer<T> consumer) {

    for (T t : list) {

      consumer.accept(t);

    }

  }
}