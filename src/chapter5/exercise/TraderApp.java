package chapter5.exercise;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TraderApp {
    public static void main(String[] args) {
        List<Transaction> transactionList = TraderService.getTransactions();
        // find all transaction in year 2011 and sort them
        Stream<Transaction> sorted = transactionList.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue));
        printInfo("All transaction in year 2011, order by value", sorted);


        // What are all the unique cities where the traders work?
        List<String> cityList = transactionList.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("=========================");
        System.out.println("All the unique cities where the traders work");
        cityList.forEach(System.out::println);


        // Find all traders from Cambridge and sort them by name
        Stream<Transaction> camBridgeTraderSortByName = transactionList.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .sorted(Comparator.comparing(t1 -> t1.getTrader().getName()));
        System.out.println("=========================");
        printInfo("All traders from Cambridge and sort them by name", camBridgeTraderSortByName);


        // Return a string of all traders’ names sorted alphabetically.
        Stream<String> sortedTraderName = transactionList.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted(Comparator.comparing(s -> s));
        System.out.println("=========================");
        printInfo("all traders’ names sorted alphabetically", sortedTraderName);

        // Are any traders based in Milan?
        boolean existTraderFromMilan = transactionList.stream().anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println("=========================");
        System.out.println("Are any traders based in Milan First Approach: " + existTraderFromMilan);

//        boolean empty = !transactionList.stream().map(t -> t.getTrader().getCity())
//                .filter(s -> "Milan" == s)
//                .collect(Collectors.toList())
//                .isEmpty();
//        System.out.println("Are any traders based in Milan Second Approach: " + empty);

        // Print all transactions’ values from the traders living in Cambridge.
        System.out.println("=========================");
        System.out.println("Print all transactions’ values from the traders living in Cambridge.");
        transactionList.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .sorted(Comparator.comparing(s -> s))
                .forEach(System.out::println);

        // What’s the highest value of all the transactions?
        Optional<Integer> highestValue = transactionList.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("=========================");
        System.out.println("What’s the highest value of all the transactions " + highestValue.orElse(0));

        // Find the transaction with the smallest value.
        Optional<Integer> minValue = transactionList.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println("=========================");
        System.out.println("What’s the lowest value of all the transactions " + minValue.orElse(0));
    }

    private static <T> void printInfo(String message, Stream<T> stream) {
        System.out.println(message);
        stream.forEach(System.out::println);
    }
}
