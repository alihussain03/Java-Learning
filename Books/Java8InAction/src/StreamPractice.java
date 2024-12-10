import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(2, 17, 5, 20, 17, 30, 4, 23, 59, 23);

        System.out.println("Find Duplicates using build in method");
        List<Integer> collect = findDuplicatesMethod1(stream);
        collect.forEach(integer -> System.out.print(integer + " "));

        System.out.println("\n----------------------------------");
        stream = Stream.of(2, 17, 5, 20, 17, 30, 4, 23, 59, 23);
        System.out.println("Find Duplicates using Set");
        findDuplicatesMethod2(stream).forEach(integer -> System.out.print(integer + " "));

        System.out.println("\n----------------------------------");
        System.out.println("Find Character count in string");
        String str = "geeksforgeeks";
        char c = 'g';
        System.out.println(count(str, c));

        System.out.println("\n----------------------------------");
        firstElement();

    }

    static List<Integer> findDuplicatesMethod1(Stream<Integer> stream) {
        return stream.distinct().collect(Collectors.toList());
    }

    static Set<Integer> findDuplicatesMethod2(Stream<Integer> stream) {
        Set<Integer> items = new HashSet<>();
        return stream.filter(integer -> items.add(integer)).collect(Collectors.toSet());
    }

    private static long count(String str, char ch) {
        return str.chars().filter(c -> c == ch).count();
    }

    private static void firstElement() {

        System.out.println("Find Element using reduce method");
        String[] input = new String[]{"Geek_First", "Geek_First2", "Geek_First3", "Geek_Last"};
        String value = Arrays.stream(input).reduce((s, s2) -> s).orElse(null);
        System.out.println(value);

        System.out.println("Find Element using Find First method");
        value = Arrays.stream(input).findFirst().orElse(null);
        System.out.println(value);
    }
}
