package chapter5;

import common.Dish;
import common.MenuUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndSlice {
    public static void main(String[] args) {
        List<Dish> allMenus = MenuUtils.getAllMenus();
        // vegetarian menu
        List<Dish> vegetarianMenus = allMenus.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        vegetarianMenus.forEach(System.out::println);
        //
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 5, 5, 6, 7, 8);
        List<Integer> integerList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .limit(3)
                .skip(2)
                .collect(Collectors.toList());
        integerList.forEach(System.out::println);
    }
}
