package com.javarush.test.level14.lesson08.home09;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 22.07.14
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }
    public String getCurrencyName()
    {
        return "USD";
    }
}
