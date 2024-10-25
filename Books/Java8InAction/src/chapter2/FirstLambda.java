package chapter2;

public class FirstLambda {
    public static void main(String[] args) {
        Thread thead = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thead.start();

        FunctionalInterfaceExample functionalInterfaceExample = () -> System.out.println("Functional Interface");
        functionalInterfaceExample.myMethod();

        passBehaviour(() -> System.out.println("Pass Behaviour Example"));
    }

    static void passBehaviour(FunctionalInterfaceExample functionalInterfaceExample) {
        functionalInterfaceExample.myMethod();
    }
}
