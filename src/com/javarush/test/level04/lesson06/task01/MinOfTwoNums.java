package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinOfTwoNums
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt( reader.readLine());
        int b = Integer.parseInt( reader.readLine());
        int min;

        if ( a < b){
        min = a;
        }
        else{
            min = b;
        }//Напишите тут ваш код
        System.out.println(min);

    }
}