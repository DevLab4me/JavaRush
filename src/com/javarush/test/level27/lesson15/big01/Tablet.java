package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.util.Observable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by Artem on 16.11.2015.
 */

public class Tablet extends Observable {
    private final int number;
    private Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number){
        this.number = number;
    }

    public void createOrder(){
        try{
            Order order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());

            if(!order.isEmpty()) {
                try {
                    AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime()*60);
                    manager.processVideos();
                }catch (NoVideoAvailableException e){
                    logger.log(Level.INFO, "No video is available for the order " + order);
                }
                setChanged();
                notifyObservers(order);
            }
        } catch (IOException e){
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    @Override
    public String toString()
    {
        return "Tablet{number=" + number + '}';
    }
}
