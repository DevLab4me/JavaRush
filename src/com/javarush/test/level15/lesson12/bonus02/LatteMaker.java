package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 28.07.14
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
public class LatteMaker extends DrinkMaker
{
    void getRightCup()
    {
        System.out.println("Берем чашку для латте");
    }
    void putIngredient()
    {
        System.out.println("Делаем кофе");
    }
    void pour()
    {
        System.out.println("Заливаем молоком с пенкой");
    }
    void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
