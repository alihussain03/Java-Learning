package Lambda;

public class EvaluationOfLambda {


  public static void main(String arg[]) {

    // Method 1
    MyRunnable myRunnable = new MyRunnable();
    Thread thread1 = new Thread(myRunnable);
    thread1.start();

    // Method 2
    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Thread is running using anonymous class ");
      }
    });
    thread2.start();

    // Method 3
    Thread thread3 = new Thread(() -> System.out.println("Thread is running using lambda"));
    thread3.start();


  }


}
