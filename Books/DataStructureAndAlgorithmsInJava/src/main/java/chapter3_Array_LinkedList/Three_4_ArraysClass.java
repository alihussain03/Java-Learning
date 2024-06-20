package chapter3_Array_LinkedList;

import java.util.Arrays;
import java.util.Random;

public class Three_4_ArraysClass {
    public static void main(String[] args) {
        char[] letters = {'B', 'C', 'D', 'A', 'E', 'H', 'G', 'F'};
        int[] numbers = {4, 2, 3, 7, 4, 2, 6, 2, 5};
        char[] fillArray = new char[5];

        Arrays.fill(fillArray, 'a');
        // Arrays.sort(letters, Collections.reverseOrder());

        Arrays.sort(letters);
        Arrays.sort(numbers);

        System.out.println(fillArray);
        System.out.println(numbers);

        System.out.println("\n Arrays class test");
        ArrayTest();

        /**
         * TODO More functions to add
         * copy
         * binarySearchTree
         *
         */
    }

    static void ArrayTest() {
        int data[] = new int[10];
        Random rand = new Random(); // a pseudo-random number generator
        rand.setSeed(System.currentTimeMillis()); // use current time as a seed
        // fill the data array with pseudo-random numbers from 0 to 99, inclusive
        for (int i = 0; i < data.length; i++)
            data[i] = rand.nextInt(100); // the next pseudo-random number
        int[] orig = Arrays.copyOf(data, data.length); // make a copy of the data array
        System.out.println("arrays equal before sort: " + Arrays.equals(data, orig));
        Arrays.sort(data); // sorting the data array (orig is unchanged)
        System.out.println("arrays equal after sort: " + Arrays.equals(data, orig));
        System.out.println("orig = " + Arrays.toString(orig));
        System.out.println("data = " + Arrays.toString(data));

    }
}
