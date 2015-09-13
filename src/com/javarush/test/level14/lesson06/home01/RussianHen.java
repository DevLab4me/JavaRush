package com.javarush.test.level14.lesson06.home01;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 21.07.14
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
public class RussianHen extends Hen
{
    @Override
    String getDescription()
    {
        return super.getDescription() + String.format( " Моя страна - %s. Я несу %d яиц в месяц.",
                Country.RUSSIA, getCountOfEggsPerMonth() );
    }

    @Override
    int getCountOfEggsPerMonth()
    {
        return 25;
    }
}