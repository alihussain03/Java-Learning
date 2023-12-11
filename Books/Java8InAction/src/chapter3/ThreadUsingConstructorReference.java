package chapter3;

import java.util.function.Function;

public class ThreadUsingConstructorReference {

  public static void main(String arg[]) {
    Function<Runnable, Thread> thread = Thread::new;
    Runnable runnable = () -> System.out.println("Thread call");
    Thread thread1 = thread.apply(runnable);
    thread1.start();

    thread.apply(() -> System.out.println("Thread 3call")).start();

    // StringArray stringArray = size -> new String[10];
    StringArray stringArray1 = String[]::new;
    stringArray1.createArray(1);

  }

  interface StringArray {

    String[] createArray(int size);
  }

}
