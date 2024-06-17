package chapter5;

public class Five_3_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(arr, 2, 0, arr.length - 1));
    }

    static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high) return false;
        else {
            int mid = (low + high) / 2;
            System.out.println("mid: " + mid + " Low: " + low + " High: " + high);
            if (target == data[mid]) return true;
            else if (target < data[mid]) return binarySearch(data, target, low, mid - 1);
            else return binarySearch(data, target, mid + 1, high);
        }
    }
}



