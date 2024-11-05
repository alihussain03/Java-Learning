package chapter4And5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MapAndFlatMap {

    public static void main(String[] args) {
        examplesFromBook();

        System.out.println("Square of each number");
        Stream.of(2, 3, 4, 5, 6).map(number -> number * number).forEach(System.out::println);
    }

    static void examplesFromBook() {
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");

        // Problem1: return array of String, Like 'hello', 'world' are 2 index array in this case
        List<String[]> listOfWords = words.stream().map(string -> string.split("")).distinct().collect(toList());
        /*
        listOfWords.forEach(word -> {
                    System.out.println(word.length);
                    for (String s : word) {
                        System.out.print(s);
                    }
                    System.out.println();
                }
        );
        */

        // Problem2:
        List<Stream<String>> listOfWords1 = words.stream().map(str -> str.split("")).map(Arrays::stream).distinct().collect(toList());

        // Solution:
        List<String> uniqueCharacters = words.stream().map(str -> str.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        uniqueCharacters.forEach(System.out::print);
        System.out.println();

        //Same above example with arrays instead of list
        String[] words1 = {"Hello", " World"};

        List<String[]> collect = Arrays.stream(words1).map(s -> s.split("")).distinct().collect(toList());
        // System.out.println(collect.size());

        System.out.println("Array uníque characters are: ");
        uniqueCharacters = Arrays.stream(words1).map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(uniqueCharacters);

        // problem 2
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        System.out.println("Print pairs :");
        List<int[]> pairs = numbers1.stream().flatMap(integer -> numbers2.stream().map(integer1 -> new int[]{integer, integer1})).collect(toList());
        pairs.forEach(array -> System.out.println("(" + array[0] + "," + array[1] + ")"));

        System.out.println("Print pairs whose are divided by 3 :");
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers4 = Arrays.asList(6, 7, 8);
        // when i =1, [(1, 6), (1, 7), (1, 8)]
        pairs = numbers3.stream().flatMap((Integer i) -> numbers4.stream().map((Integer j) -> new int[]{i, j})).filter(pair -> (pair[0] + pair[1]) % 3 == 0).collect(toList());
        pairs.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));
    }

}
