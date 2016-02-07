package com.javarush.test.More.TestStudies;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Artem on 16.11.2015.
 */

public class enumTest {
    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(Dish.values());
        String res = Dish.allDishesToString();
        System.out.println(res);
        System.out.println(dishes.toString());
    }
    public enum Dish{
        Fish, Steak, Soup, Juice, Water;

        public static String allDishesToString(){
            StringBuilder allDishes = new StringBuilder();
            Dish [] dishes = Dish.values();
            for(Dish dish : dishes){
                if(dish.equals(dishes[dishes.length-1])){
                    allDishes.append(dish.toString());
                } else
                allDishes.append(dish.toString()).append(", ");
            }
            return allDishes.toString();
        }
    }
}
