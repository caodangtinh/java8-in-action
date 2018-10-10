package chapter5;

import common.Dish;
import common.MenuUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args) {
        List<Dish> allMenus = MenuUtils.getAllMenus();
        List<String> collect = allMenus.stream().map(Dish::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);
        List<Integer> integerList = allMenus.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        integerList.forEach(System.out::println);
    }
}
