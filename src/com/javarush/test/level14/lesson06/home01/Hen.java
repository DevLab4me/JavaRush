package com.javarush.test.level14.lesson06.home01;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 21.07.14
 * Time: 22:01
 * To change this template use File | Settings | File Templates.
 */
public abstract class Hen
{
    abstract int getCountOfEggsPerMonth();
    String getDescription(){
        return "Я курица.";
    }
}
