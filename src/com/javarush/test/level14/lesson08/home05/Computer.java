package com.javarush.test.level14.lesson08.home05;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 22.07.14
 * Time: 13:06
 * To change this template use File | Settings | File Templates.
 */
public class Computer
{
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Computer()
    {
        this.mouse = new Mouse();
        this.monitor = new Monitor();
        this.keyboard = new Keyboard();
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }
}
