package old.chapter4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise {

    public static void main(String... args) throws IOException {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1.  Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> firstCase = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011).sorted
                        (Comparator.comparing(transaction -> transaction.getValue(),
                                (integer, t1) -> t1.compareTo(integer)))
                .collect(
                        Collectors.toList());
        firstCase.forEach(System.out::println);
        System.out.println();

        List<Transaction> firstCaseUsingMethod = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(
                        Collectors.toList());
        firstCaseUsingMethod.forEach(System.out::println);

        // 2.  What are all the unique cities where the traders work?
        System.out.println();
        List<String> secondCase = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity()).distinct()
                .collect(Collectors.toList());
        secondCase.forEach(System.out::println);

        // 3.  What are all the unique cities where the traders work?
        System.out.println();
        List<Transaction> thirdCase = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).distinct()
                .sorted(Comparator.comparing(transaction -> transaction.getTrader().getName(),
                        (s, t1) -> s.compareTo(t1)))
                .collect(Collectors.toList());

        List<Trader> thirdCaseUsing2Method = transactions.stream().map(Transaction::getTrader)
                .filter(transaction -> transaction.getCity().equals("Cambridge")).distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        thirdCase.forEach(System.out::println);

        System.out.println();
        //4.  Return a string of all traders’ names sorted alphabetically.
        List<Trader> sortByTraderName = transactions.stream().map(Transaction::getTrader).distinct()
                .sorted(
                        Comparator.comparing(Trader::getName)
                ).collect(Collectors.toList());
        sortByTraderName.forEach(System.out::println);

        //5   Are any traders based in Milan?
        Boolean sortByCityName = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        sortByTraderName.forEach(System.out::println);

        //6  Print all transactions’ values from the traders living in Cambridge.
        System.out.println("point6");

        boolean cambridge = transactions.stream()
                .allMatch(transaction -> transaction.getTrader().getCity().equals("Cambridge"));

        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue).forEach(System.out::println);

        //7 What’s the highest value of all the transactions?
        System.out.println("number7");
        Optional<Integer> number7 = transactions.stream().map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(number7.get());

        transactions.stream().reduce(
                (transaction, transaction2) -> transaction.getValue() < transaction2.getValue()
                        ? transaction : transaction2);
    }

}
