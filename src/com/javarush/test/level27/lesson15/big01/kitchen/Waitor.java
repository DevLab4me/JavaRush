package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Artem on 17.11.2015.
 */

public class Waitor implements Observer {
    @Override
    public void update(Observable cook, Object order) {
        ConsoleHelper.writeMessage(order + " was cooked by " + cook);
    }
}
