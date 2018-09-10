package chapter1;

public class GreenAndHeavyApplePredicate implements ApplePredicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor()) && 150 < apple.getWeight();
    }
}
