package com.javarush.test.level14.lesson06.home01;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 21.07.14
 * Time: 21:59
 * To change this template use File | Settings | File Templates.
 */
public class MoldovanHen extends Hen
{
    @Override
    String getDescription()
    {
        return super.getDescription() + String.format( " Моя страна - %s. Я несу %d яиц в месяц.",
                Country.MOLDOVA, getCountOfEggsPerMonth() );
    }

    @Override
    int getCountOfEggsPerMonth()
    {
        return 18;
    }
}