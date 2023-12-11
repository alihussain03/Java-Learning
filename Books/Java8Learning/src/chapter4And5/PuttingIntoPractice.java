package chapter4And5;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

  public static void main(String... args) {
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

    // problem 1
    transactions.stream().filter(transaction -> transaction.getYear() == 2011)
        .sorted(
            comparing(Transaction::getValue)
        ).forEach(System.out::println);

    // problem 2
    transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct()
        .forEach(System.out::println);

    Set<String> cities = transactions.stream()
        .map(transaction -> transaction.getTrader().getCity()).distinct()
        .collect(Collectors.toSet());

    // problem 3

    List<Trader> traders = transactions.stream()
        .map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge"))
        .sorted(comparing(Trader::getName))
        .collect(Collectors.toList());

    // problem 4

    Optional<String> reduce = transactions.stream().map(Transaction::getTrader).map(Trader::getName)
        .distinct().sorted().reduce((s, s2) -> s + s2);

    String reduce1 = transactions.stream()
        .map(transaction -> transaction.getTrader().getName()).distinct().sorted()
        .reduce("", (s, s2) -> s + s2);
    System.out.println(reduce1);

    String reduce2 = transactions.stream()
        .map(transaction -> transaction.getTrader().getName()).distinct().sorted()
        .collect(Collectors.joining());

    // problem 5
    transactions.stream()
        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

    // problem 6
    transactions.stream()
        .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
        .map(Transaction::getValue).forEach(System.out::println);

    // problem 7
    Optional<Integer> max = transactions.stream()
        .map(transaction -> transaction.getValue()).reduce(Integer::max);

    //problem 8
    Optional<Transaction> min = transactions.stream().reduce(
        (transaction, transaction2) -> transaction.getValue() < transaction2.getValue()
            ? transaction : transaction2);

    Optional<Transaction> min1 = transactions.stream()
        .min(comparing(Transaction::getValue));

    System.out.println(min.get().getValue());
    System.out.println(min1.get().getValue());

    Optional<Transaction> smallestTransaction = transactions.stream()
        .min(comparing(Transaction::getValue));
    // Here I cheat a bit by converting the found Transaction (if any) to a String
    // so that I can use a default String if no transactions are found (i.e. the Stream is empty).
    System.out.println(smallestTransaction.map(String::valueOf).orElse("No transactions found"));
  }
}
