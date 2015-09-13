package com.javarush.test.level15.lesson12.home05;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 27.07.14
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */
public class SubSolution extends Solution
{
    public SubSolution(String name)
    {
        super(name);
    }

    public SubSolution(int name)
    {
        super(name);
    }

    public SubSolution(Object name)
    {
        super(name);
    }
    private SubSolution(Integer name)
    {
        super(name);
    }
    private SubSolution(Character name)
    {
        super(name);
    }
    private SubSolution(Exception one)
    {
        super(one);
    }
    protected SubSolution(String name, int age)
    {
        super(name, age);
    }

    protected SubSolution(int name, int age)
    {
        super(name, age);
    }

    protected SubSolution(Object name, int age)
    {
        super(name, age);
    }

    SubSolution(float height, int weight)
    {

        super(height, weight);
    }

    SubSolution(double height, int weight)
    {
        super(height, weight);
    }

    SubSolution(Integer height, int weight)
    {
        super(height, weight);
    }

}
