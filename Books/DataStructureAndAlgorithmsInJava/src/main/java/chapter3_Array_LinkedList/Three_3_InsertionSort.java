package chapter3_Array_LinkedList;

import java.util.Arrays;

public class Three_3_InsertionSort {
    public static void main(String[] args) {
        char[] letters = {'B', 'C', 'D', 'A', 'E', 'H', 'G', 'F'};
        int[] numbers = {4, 2, 3, 7, 4, 2, 6, 2, 5};

        insertSort(letters); // sort character array
        System.out.println(Arrays.toString(numbers));

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

    public static void insertSortForNumbers(int[] arrayOfData) {
        System.out.println("\nData length is \n" + arrayOfData.length + "\n");

        for (int k = 1; k < arrayOfData.length; k++) {
            int currentData = arrayOfData[k];
            int j = k;
            while (j > 0 && arrayOfData[j - 1] > currentData) {
                System.out.println("j is " + j + " and j-1 is " + (j - 1));
                arrayOfData[j] = arrayOfData[j - 1]; //slide arrayOfData right
                j--;
            }
            arrayOfData[j] = currentData;
        }
        for (int data : arrayOfData) {
            System.out.println(data);
        }
    }
}
