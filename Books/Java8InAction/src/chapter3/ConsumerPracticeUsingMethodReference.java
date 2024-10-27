package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerPracticeUsingMethodReference {

    public static void main(String arg[]) {
        List<String> listOfString = new ArrayList<>();
        listOfString.add("Hello World");
        listOfString.add("Nokia");
        listOfString.add("Hello World");
        listOfString.add("Nokia");

        Consumer<String> consumer = System.out::println;

        printUsingConsumer(listOfString, consumer);

    }

    static <T> void printUsingConsumer(List<T> list, Consumer<T> consumer) {
        list.forEach(t -> {
            consumer.accept(t);
        });

    }


}
