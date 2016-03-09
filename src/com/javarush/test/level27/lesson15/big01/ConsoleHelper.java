package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem on 17.11.2015.
 */

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        String message = "";
        try{
            message = reader.readLine();
        } catch (IOException ignored){

        }
        return message;
    }
    public static List<Dish> getAllDishesForOrder(){
        List<Dish> order = new ArrayList<>();
        writeMessage("Please, choose what you would like to order from the list below(type 'exit' to finish):");
        writeMessage(Dish.allDishesToString());
        String dish = readString();

        while(!dish.equalsIgnoreCase("exit")){
            try
            {
                order.add(Dish.valueOf(dish));
            }
            catch (IllegalArgumentException e)
            {
                ConsoleHelper.writeMessage(dish + " is not detected");
            }
            dish = readString();
        }

        return order;
    }
}
