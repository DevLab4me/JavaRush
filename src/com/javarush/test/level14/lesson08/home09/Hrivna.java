package com.javarush.test.level14.lesson08.home09;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 22.07.14
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Hrivna extends Money
{
    public Hrivna(double amount)
    {
          super(amount);
    }

    public String getCurrencyName()
    {
        return "HRN";
    }
}
