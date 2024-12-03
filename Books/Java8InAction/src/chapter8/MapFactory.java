package chapter8;

import java.util.HashMap;
import java.util.Map;

public class MapFactory {
    public static void main(String[] args) {
        // First factory method
        Map<String, Integer> employees = Map.of("Evellina", 40, "Timo", 35);
        System.out.println(employees);

        // second factory method
        System.out.println("---------------------------");
        employees = Map.ofEntries(Map.entry("Evellina", 40), Map.entry("Timo", 40));
        System.out.println(employees);

        System.out.println("---------------------------");
        System.out.println("For Each for map:");
        employees.forEach((key, value) -> System.out.println(key + " -- " + value));


        System.out.println("---------------------------");
        System.out.println("Example of Computer if absent");
        Map<String, String> map = new HashMap<>();

        map.put("apple", "fruit");
        map.put("carrot", "vegetable");

        // Use computeIfAbsent to compute value for key 'banana'
        map.computeIfAbsent("banana", key -> "fruit");
        System.out.println(map);

        System.out.println("\nExample of Computer if present");
        map.computeIfPresent("banana", (key, value) -> value + 2);
        System.out.println(map);

        System.out.println("\n---------------------------");
        System.out.println("Example of remove");
        map.remove("banana");
        System.out.println(map);

        System.out.println("\n---------------------------");
        System.out.println("Example of replaceAll");
        map.replaceAll((s, s2) -> s2.toUpperCase());
        System.out.println(map);

        System.out.println("\n---------------------------");
        System.out.println("Example of replace");
        map.replace("apple", "fruit", "FRUIT");
        System.out.println(map);

        System.out.println("\n---------------------------");
        System.out.println("Example of putAll");

        Map<String, String> javaOld = Map.ofEntries(Map.entry("Java8", "2020"), Map.entry("Java7", "2017"));
        Map<String, String> javaLatest = Map.ofEntries(Map.entry("Java11", "2022"), Map.entry("Java21", "2024"));
        Map<String, String> java = new HashMap<>(javaOld);
        java.putAll(javaLatest);
        System.out.println(java);
    }
}
