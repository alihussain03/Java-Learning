package chapter5;

public class five_5_LinearRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(linearSumForNElements(arr, 4));
        System.out.println("Array sum: " + linearSumForArray(arr, arr.length - 1));
        System.out.println("Fibonacci: " + fibonacci(4));
        System.out.println("Number after print are : ");
        printNumber(5);
        reverseArray(arr, 0, arr.length - 1);
      //  Arrays.stream(arr).forEach(System.out::print);
        System.out.println("Power is: " + power(8,2));
        System.out.println("Power is 0logn): " + powerSecondMethod(8,2));
    }

    private static int linearSumForNElements(int[] data, int n) {
        if (n == 0) return 0;
        else
            return linearSumForNElements(data, n - 1) + data[n - 1];
    }

    private static int linearSumForArray(int[] data, int n) {
        // if (n == 0) return data[0];
        if (n < 0) return 0;
        else {
            //  System.out.println("n: "+n+" data[n]: "+data[n]);
            return linearSumForArray(data, n - 1) + data[n];
        }

    }

    private static int fibonacci(int n) {
        if (n <= 1) return n;
        else {
            int temp = fibonacci(n - 1);
            int temp2 = fibonacci(n - 2);
            return temp + temp2;
            //   return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    private static void printNumber(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        } else {
            printNumber(n - 1);
            System.out.println(n);
        }
    }

    public static void reverseArray(int[] data, int low, int high) {
        if (low < high) {
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;

            reverseArray(data, low + 1, high - 1);
        }

    }

    public static double power(double x, int n) {
        if (n == 0) return 1;
        else return x * power(x, n - 1);
    }

    public static double powerSecondMethod(double x, int n) {
        if (n == 0) return 1;
        else return x * power(x, n - 1);
    }


}
