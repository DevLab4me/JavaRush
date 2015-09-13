package com.javarush.test.level04.lesson16.home03;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TotalOfAllNums
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        while ( true )
        {
            int nextNumber = Integer.parseInt( br.readLine() );
            sum += nextNumber;
            if ( nextNumber == -1 )
            {
                break;
            }
        }

        System.out.println( sum );//Напишите тут ваш код
    }
}
