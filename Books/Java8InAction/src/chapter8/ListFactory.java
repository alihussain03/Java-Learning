package chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListFactory {
    public static void main(String[] args) {
        // create a list which in immutable like cannot add or remove elements but can update elements using set method
        System.out.println("List using Arrays.asList method ");
        List<String> java = Arrays.asList("Java8", "In action", "2024");
        java.set(0, "Update");
        System.out.println(java + "\n");

        // The List.of method creates an immutable list. This means the list cannot be modified after creation.
        // Any attempt to modify the list, such as adding, removing, or changing elements, will result in an exception.
        System.out.println("---------------------------");
        System.out.println("List using List.of method ");
        java = List.of("Java8", "In action", "2024");
        System.out.println(java + "\n");

        System.out.println("---------------------------");
        System.out.println("Create list using ArrayList");
        java = new ArrayList<>(List.of("Java8", "In action", "2024"));

        java.removeIf(s -> s.equals("2024"));
        System.out.println("List after removeIf");
        System.out.println(java + "\n");

        System.out.println("---------------------------");
        System.out.println("Example of replace all");
        List<String> words = new ArrayList<>(List.of("cherry", "apple", "banana"));
        words.replaceAll(String::toUpperCase); // Apply the `toUpperCase` method to each element
        System.out.println(words + "\n");

        //Sorting method
        System.out.println("---------------------------");
        System.out.println("Example of Sorting Method");
        words.sort(Comparator.naturalOrder());
        System.out.println(words + "\n");
    }
}
