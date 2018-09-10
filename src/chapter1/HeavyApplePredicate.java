package chapter1;

public class HeavyApplePredicate implements ApplePredicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return 150 < apple.getWeight();
    }
}
