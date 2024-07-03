import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class QuickUnion_1 {
    int[] id;
    int count;

    public QuickUnion_1(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public void printId() {
        Arrays.stream(id).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnion_1 UF = new QuickUnion_1(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (UF.isConnected(p, q)) continue;
            UF.union(p, q);
        }
        UF.printId();
    }
}
