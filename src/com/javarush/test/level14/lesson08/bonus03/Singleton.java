package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 22.07.14
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class Singleton
{
    private static Singleton instance;

    private Singleton()
    {

    }
    public static Singleton getInstance()
    {
        if (instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}
