package chapter1;

public class GreenApplePredicate implements ApplePredicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
