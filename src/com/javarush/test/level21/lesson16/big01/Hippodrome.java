package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;


public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main (String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Flash", 3, 0));
        game.getHorses().add(new Horse("Lucky", 3, 0));
        game.getHorses().add(new Horse("Captain", 3, 0));
        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void move () {
        for (Horse currentHorse : horses)
            currentHorse.move();
    }

    public void print() {
        for (Horse currentHorse : horses)
            currentHorse.print();
        System.out.println();
        System.out.println();
    }

    public void run()
    {
        try {
            for (int i = 0; i < 100; i++) {
                move();
                print();
                Thread.sleep(500);
            }
        } catch (InterruptedException e){}
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (Horse horse : horses)
        {
            if (horse.getDistance() > winner.getDistance())
                winner = horse;
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
}