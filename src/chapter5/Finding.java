package chapter5;

import common.Dish;
import common.MenuUtils;

import java.util.List;

public class Finding {
    public static void main(String[] args) {
        List<Dish> allMenus = MenuUtils.getAllMenus();
        System.out.println(allMenus.stream().noneMatch(Dish::isVegetarian));
    }
}
