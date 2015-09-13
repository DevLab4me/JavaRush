package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    public int ceneterX;
    public int centerY;
    public int radius;
    public int width;
    public String color;

    public void initialize(int ceneterX, int centerY, int radius){
        this.ceneterX = ceneterX;
        this.centerY = centerY;
        this.radius = radius;

    }
    public void initialize(int ceneterX, int centerY, int radius, int width){
        this.ceneterX = ceneterX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        //Напишите тут ваш код
    }
    public void initialize(int ceneterX, int centerY, int radius, int width, String color){
        this.ceneterX = ceneterX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }
}
