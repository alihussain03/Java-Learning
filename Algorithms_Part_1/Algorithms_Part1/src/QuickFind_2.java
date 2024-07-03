import edu.princeton.cs.algs4.StdIn;

public class QuickFind_2 {
    int[] id;
    int count;

    public QuickFind_2(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public QuickFind_2(int[] n) {
        id = n;
    }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                //    System.out.println("id[i] = " + id[i] + " pId = " + pId + " qId = " + qId);
                id[i] = qId;
            }
        }

    }

    public static void main(String[] args) {
        QuickFind_2 quickUnionFind = new QuickFind_2(5);
        quickUnionFind.union(0, 1);
        quickUnionFind.union(1, 2);
        System.out.println(quickUnionFind.isConnected(0, 2));

        //   Arrays.stream(getArraySize()).forEach(System.out::println);

        QuickFind_2 quickUnionFind2 = new QuickFind_2(new int[]{8, 9, 7, 1});
        quickUnionFind2.union(2, 3);
        quickUnionFind2.union(2, 1);

        //    Arrays.stream(getId()).forEach(System.out::println);


        int n = StdIn.readInt();
        QuickFind_2 UF = new QuickFind_2(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (UF.isConnected(p, q)) continue;
            UF.union(p, q);
            //    System.out.println(p + " " + q);
        }
        System.out.println(UF.count() + " components");

    }


}
