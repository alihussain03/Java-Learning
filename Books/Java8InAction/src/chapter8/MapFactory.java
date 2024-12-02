package chapter8;

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
    }
}
