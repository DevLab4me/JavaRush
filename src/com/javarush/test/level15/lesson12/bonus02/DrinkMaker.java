package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 28.07.14
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();     // - выбрать подходящую чашку
    abstract void putIngredient();   // - положить ингредиенты
    abstract void pour();            // - залить жидкостью
    void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
