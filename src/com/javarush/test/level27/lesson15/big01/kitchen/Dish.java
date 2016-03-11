package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Artem on 16.11.2015.
 */

public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;
    Dish(int duration){
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

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
