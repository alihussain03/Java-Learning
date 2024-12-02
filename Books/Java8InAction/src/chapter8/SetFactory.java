package chapter8;

import java.util.HashSet;
import java.util.Set;

public class SetFactory {
    public static void main(String[] args) {
        // The Set.of method creates an immutable Set. This means the Set cannot be modified after creation.
        // Any attempt to modify the Set, such as adding, removing, or changing elements, will result in an exception.
        Set<String> java = Set.of("Java8", "In action", "2024"); // does not guarantee the order
        System.out.println(java);

        System.out.println("---------------------------");
        System.out.println("Example of remove if");
        Set<String> set = new HashSet<>(Set.of("Apple", "Banana", "Cherry", "Date"));
        set.removeIf(s -> s.startsWith("B")); // Remove elements starting with 'B'
        System.out.println(set); // Output: [Apple, Cherry, Date]
    }
}
