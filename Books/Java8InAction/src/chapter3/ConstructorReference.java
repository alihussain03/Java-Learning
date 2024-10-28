package chapter3;

import chapter2.Apple;
import chapter2.Color;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {

    public static void main(String[] args) {
        System.out.println("Constructor Reference");

        Function<Runnable, Thread> functionalInterface = runnable -> new Thread(runnable);

        //Using constructor Reference
        Function<Runnable, Thread> threadGenerator = Thread::new;
        Runnable task1 = () -> System.out.println("Task 1 executed");
        Runnable task2 = () -> System.out.println("Task 2 executed");

        Thread thread1 = threadGenerator.apply(task1);
        Thread thread2 = threadGenerator.apply(task2);

        thread1.start();
        thread2.start();

        threadGenerator.apply(() -> System.out.println("Task 3 executed")).start();
    }
}
