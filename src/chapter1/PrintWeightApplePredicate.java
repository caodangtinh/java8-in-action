package chapter1;

public class PrintWeightApplePredicate implements  PrintApplePredicate<Apple> {
    @Override
    public void print(Apple apple) {
        System.out.println("Apple weight " + apple.getWeight());
    }
}
