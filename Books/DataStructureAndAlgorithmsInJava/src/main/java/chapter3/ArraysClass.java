package chapter3;

import java.util.Arrays;

public class ArraysClass {
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

        /**
         * TODO More functions to add
         * copy
         * binarySearchTree
         *
         */
    }
}
