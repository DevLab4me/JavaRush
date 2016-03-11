package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Artem on 16.11.2015.
 */

public class Order {
    private Tablet tablet;
    public List<Dish> dishes;

    public Order(Tablet tablet)throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime(){
        int cookingTime = 0;
        for (Dish dish : dishes){
            cookingTime += dish.getDuration();
        }
        return cookingTime;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        if(dishes.isEmpty()){
            return "";
        } else
        return "Your order: " + dishes.toString() + " of " + tablet.toString();
    }
}
