package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 28.07.14
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
public class TeaMaker extends DrinkMaker
{
    void getRightCup()
    {
        System.out.println("Берем чашку для чая");
    }
    void putIngredient()
    {
        System.out.println("Насыпаем чай");
    }
    void pour()
    {
        System.out.println("Заливаем водой");
    }
    public void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
