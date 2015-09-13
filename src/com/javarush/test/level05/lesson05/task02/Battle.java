package com.javarush.test.level05.lesson05.task02;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 22.04.14
 * Time: 12:51
 * To change this template use File | Settings | File Templates.
 */
public class Battle{
    public static void main(String[] args){

    Cat cat1 = new Cat();
    Cat anotherCat = new Cat();

    cat1.name = "Murzik";
    cat1.age = 5;
    cat1.weight = 10;
    cat1.strength = 15;

    anotherCat.name = "Barsik";
    anotherCat.age = 6;
    anotherCat.weight = 8;
    anotherCat.strength = 16;

    System.out.println(cat1.fight(anotherCat));
    System.out.println(anotherCat.fight(cat1));

    }
}

