package chapter5;

public class five_6_BinaryRecursion {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5};
        System.out.println(binarySum(data, 0, data.length - 1));
    }

    private static int binarySum(int[] data, int low, int high) {
        if (low > high) return 0;
        else if (low == high) return data[low];
        else {
            int mid = (low + high) / 2;
            int left = binarySum(data, low, mid);
            int right = binarySum(data, mid + 1, high);
            return left + right;
        }

    }
}
