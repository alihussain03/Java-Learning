package chapter5_Recursion;

import java.io.File;

public class Five_4_DiskSpace {
    public static void main(String[] args) {
    diskUsage(new File("/Users/a1hussai/Downloads/"));
    }

    public static long diskUsage(File root) {
        long total = root.length(); // start with direct disk usage
        if (root.isDirectory()) { // and if this is a directory,
            for (String childname : root.list()) { // then for each child
                File child = new File(root, childname); // compose full path to child
                total += diskUsage(child); // add child’s usage to total
            }
        }
        System.out.println(total + "\t" + root); // descriptive output
        return total; // return the grand total
    }
}
