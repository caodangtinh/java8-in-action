package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListApple {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        // filter green apple
        filterApple(inventory, ListApple::isGreenApple);
        filterApple(inventory, (Apple a) -> "green".equals(a.getColor()));
        // filter heavy apple
        filterApple(inventory, ListApple::isHeavyApple);
        filterApple(inventory, (Apple a) -> a.getWeight() > 150);

        filterApple(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        inventory.stream()
                .filter(ListApple::isGreenApple)
                .collect(Collectors.toList());
        inventory.parallelStream().filter(ListApple::isGreenApple)
                .collect(Collectors.toList());
        List<Apple> appleList = filter(inventory, new GreenApplePredicate());
        List<Apple> filter = filter(inventory, new HeavyApplePredicate());
        List<Apple> apples = filter(inventory, new GreenAndHeavyApplePredicate());
        printApple(inventory, new PrintAppleWithWeightPredicate());
        printApple(inventory, new PrintWeightApplePredicate());
    }

    // before java 8
    public static List<Apple> filterGreenApple(List<Apple> appleList) {
        List<Apple> greenApple = new ArrayList<>();
        for (Apple apple : appleList) {
            if ("green".equals(apple.getColor())) {
                greenApple.add(apple);
            }
        }
        return greenApple;
    }

    public static List<Apple> filterHeavyApple(List<Apple> appleList) {
        List<Apple> heavyApple = new ArrayList<>();
        for (Apple apple : appleList) {
            if (apple.getWeight() > 150) {
                heavyApple.add(apple);
            }
        }
        return heavyApple;
    }

    // java 8

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple);
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApple(List<Apple> appleList, Predicate<Apple> predicate) {
        List<Apple> filterApple = new ArrayList<>();
        for (Apple apple : appleList) {
            if (predicate.test(apple)) {
                filterApple.add(apple);
            }
        }
        return filterApple;
    }

    // before java 8
    public static List<Apple> filterByColor(List<Apple> appleList, String color) {
        List<Apple> greenApple = new ArrayList<>();
        for (Apple apple : appleList) {
            if (color.equals(apple.getColor())) {
                greenApple.add(apple);
            }
        }
        return greenApple;
    }


    // java 8 behavior parameterization
    public static List<Apple> filter(List<Apple> appleList, ApplePredicate<Apple> applePredicate) {
        List<Apple> greenApple = new ArrayList<>();
        for (Apple apple : appleList) {
            if (applePredicate.test(apple)) {
                greenApple.add(apple);
            }
        }
        return greenApple;
    }

    public static void printApple(List<Apple> appleList, PrintApplePredicate<Apple> applePredicate) {
        for (Apple apple : appleList) {
            applePredicate.print(apple);
        }
    }


}
