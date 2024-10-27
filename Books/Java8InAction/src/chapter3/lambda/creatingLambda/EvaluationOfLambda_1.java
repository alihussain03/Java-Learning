package chapter3.lambda.creatingLambda;

public class EvaluationOfLambda_1 {


    public static void main(String arg[]) {

        // Method 1
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        // Method 2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("it is running");
            }
        });
        thread2.start();

        // Method 3
        Thread thread3 = new Thread(() -> System.out.println("Hello "));
        thread3.start();

        //lambda with no parameter and return type
        FunctionalInterfaceDemo functionalInterfaceDemo = () -> System.out.println(
                "Functional interface demo");
        functionalInterfaceDemo.helloWorldPrint();

        passOnTheFlyDemo(() -> System.out.println("PassOnTheFlyDemo "));

        passOnTheFlyDemo(new FunctionalInterfaceDemo() {
            @Override
            public void helloWorldPrint() {
                System.out.println("Hell code, bad now");
            }
        });

        //lambda with two parameter and no return type
        InterfaceForTwoParametersAndNoReturnType addNumbers = (a, b) -> System.out.println(a + b);
        addNumbers.operation(4, 5);

        InterfaceForTwoParametersAndNoReturnType multiply = (a, b) -> System.out.println(a * b);
        multiply.operation(4, 5);

        //lambda with one parameter and return type
        InterfaceForOneParametersAndReturnType interfaceForOneParametersAndReturnType = s ->
                s.length();
        ;
        System.out.println(interfaceForOneParametersAndReturnType.stringLength("Ali"));

    }

    public static void passOnTheFlyDemo(FunctionalInterfaceDemo functionalInterfaceDemo) {
        functionalInterfaceDemo.helloWorldPrint();

    }


}
