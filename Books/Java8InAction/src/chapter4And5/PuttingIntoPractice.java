package chapter4And5;

import chapter4And5.pojo.Trader;
import chapter4And5.pojo.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class PuttingIntoPractice {

    public static void main(String... args) {
        List<Transaction> transactions = getTransactions();

        // find all transactions in year 2011 and sort by value (small to high)
        System.out.println("Find all transactions in year 2011 and sort by value (small to high): ");
        transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(comparing(Transaction::getValue)).forEach(System.out::println);

        // find all unique cities where traders work
        System.out.println("find all unique cities where traders work: ");
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().forEach(System.out::println);

        System.out.println("find all unique cities where traders work using Set: ");
        Set<String> cities = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toSet());
        System.out.println(cities);

        // find all the traders from Cambridge name and sort them by name
        System.out.println("Find all the traders from Cambridge name and sort them by name");
        List<Trader> traders = transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).sorted(comparing(Trader::getName)).collect(Collectors.toList());
        traders.forEach(System.out::println);

        // return a string of all traders names sorted alphabetically
        System.out.println("Return a string of all traders names sorted alphabetically");
        transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted().reduce((string, string2) -> string + " " + string2).ifPresent(System.out::println);

        System.out.println("Return a string of all traders names sorted alphabetically using Joining");
        String name = transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted().collect(Collectors.joining());
        System.out.println(name);

        // any trader base in milan
        boolean anyTraderFromMilan = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("Any trader from milan: " + anyTraderFromMilan);

        // print the values of all  transactions from the traders living in cambridge
        transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);

        // highest value of all transactions
        Optional<Integer> max = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println("Highest Transaction : " + max);

        Optional<Transaction> smallestTransaction = transactions.stream().min(comparing(Transaction::getValue));

        // Here I cheat a bit by converting the found Transaction (if any) to a String
        // so that I can use a default String if no transactions are found (i.e. the Stream is empty).
        System.out.println(smallestTransaction.map(String::valueOf).orElse("No transactions found"));
    }

    private static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
    }
}
