package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

/**
 * Created by Artem on 16.11.2015.
 */

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);

        Cook cook = new Cook("Amigo");
        tablet.addObserver(cook);

        Waitor waiter = new Waitor();
        cook.addObserver(waiter);
        tablet.createOrder();
    }
}
