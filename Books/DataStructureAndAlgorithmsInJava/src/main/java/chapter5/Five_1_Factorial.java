package chapter5;

public class Five_1_Factorial {
    public static void main(String[] args) {
        int n = 5;

        System.out.println("Factorial Using Recursion is " + n + " is " + factorialWithoutRecursion(10));

        System.out.println("Factorial Using Without Recursion is " + n + " is " + factorialWithoutRecursion(10));

    }

    private static int factorialUsingRecursion(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorialUsingRecursion(n - 1);
    }

    private static int factorialWithoutRecursion(int n) {
        int fact = 1;
        while (n > 0) {
            fact = fact * n;
            n--;
        }
        return fact;
    }
}
