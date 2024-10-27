package chapter3.lambda.predefinedfunctionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice {

    public static void main(String[] arg) {
        List<String> listOfString = new ArrayList<>();
        listOfString.add("Hello World");
        listOfString.add("Nokia");
        listOfString.add("Hello World");
        listOfString.add("Nokia");

        Consumer<String> consumer = s -> System.out.println(s);

        printUsingConsumer(listOfString, consumer);

    }

    static <T> void printUsingConsumer(List<T> list, Consumer<T> consumer) {
        list.forEach(t -> {
            consumer.accept(t);
        });

    }


}
