package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxOfFourNums
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt( reader.readLine());//Напишите тут ваш код
        int b = Integer.parseInt( reader.readLine());
        int c = Integer.parseInt( reader.readLine());
        int d = Integer.parseInt( reader.readLine());

        System.out.println(max(a, b, c, d));
    }

    private static int max( int a, int b, int c, int d )
    {
        return max( max( a, b ), max( c, d ) );
    }

    private static int max( int a, int b )
    {
        return a > b ? a : b;

    }

}
