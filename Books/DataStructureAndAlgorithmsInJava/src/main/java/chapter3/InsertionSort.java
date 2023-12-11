package chapter3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class InsertionSort {
    public static void main(String[] args) {
        char[] letters = {'B', 'C', 'D', 'A', 'E', 'H', 'G', 'F'};
        int[] numbers = {4, 2, 3, 7, 4, 2, 6, 2, 5};
        insertSort(letters); // sort character array
        System.out.println(letters);

        insertSortForNumbers(numbers); // sort character array

        char[] fillArray = new char[5];
        Arrays.fill(fillArray, 'a');
        // Arrays.sort(letters, Collections.reverseOrder());

        Arrays.sort(letters);

        System.out.println(fillArray);
    }

    public static void insertSort(char[] data) {
        for (int k = 1; k < data.length; k++) {
            char currentData = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > currentData) {
                data[j] = data[j - 1]; //slide data right
                j--;
            }
            data[j] = currentData;
        }

    }

    public static void insertSortForNumbers(int[] data) {
        for (int k = 1; k < data.length; k++) {
            int currentData = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > currentData) {
                data[j] = data[j - 1]; //slide data right
                j--;
            }
            data[j] = currentData;
        }
        for (int datum : data) {
            System.out.print(datum);
        }
    }
}
