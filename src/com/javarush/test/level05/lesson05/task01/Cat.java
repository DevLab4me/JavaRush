package com.javarush.test.level05.lesson05.task01;

/* Создать класс Cat
Создать класс Cat. У кота должно быть имя (name, String), возраст (age, int), вес (weight, int), сила (strength, int).
*/

public class Cat
{
    String name;
    int age;
    int weight;
    int strength;

    public void initialize( String name )
    {
        this.name = name;
        this.age = 2;
        this.weight = 3;
    }

    public void initialize( String name, int weight, int age )
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public void initialize( String name, int age )
    {
        this.name = name;
        this.age = age;
        this.weight = 3;
    }

    public void initialize( int weight, int strength )
    {
        this.weight = weight;
        this.strength = strength;
        this.age = 2;
    }
}
