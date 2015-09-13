package com.javarush.test.level14.lesson06.home01;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 21.07.14
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
public class UkrainianHen extends Hen
{
    @Override
    String getDescription()
    {
        return super.getDescription() + String.format( " Моя страна - %s. Я несу %d яиц в месяц.",
                Country.UKRAINE, getCountOfEggsPerMonth() );
    }

    @Override
    int getCountOfEggsPerMonth()
    {
        return 50;
    }
}
