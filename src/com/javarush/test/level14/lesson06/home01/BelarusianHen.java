package com.javarush.test.level14.lesson06.home01;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 21.07.14
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public class BelarusianHen extends Hen
{
    @Override
    String getDescription()
    {
        return super.getDescription() + String.format( " Моя страна - %s. Я несу %d яиц в месяц.",
                Country.BELARUS, getCountOfEggsPerMonth() );
    }

    @Override
    int getCountOfEggsPerMonth()
    {
        return 40;
    }
}