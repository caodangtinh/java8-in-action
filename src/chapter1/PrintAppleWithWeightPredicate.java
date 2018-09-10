package chapter1;

public class PrintAppleWithWeightPredicate implements PrintApplePredicate<Apple> {
    @Override
    public void print(Apple apple) {
        System.out.println("Apple is " + (150 > apple.getWeight() ? " heavy" : " light"));
    }
}
