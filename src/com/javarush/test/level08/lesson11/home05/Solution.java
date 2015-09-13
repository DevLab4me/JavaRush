package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Пример ввода:
мама     мыла раму.
Пример вывода:
Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String result = "";
        char[] letters = s.toCharArray();

        for ( int i = 0; i < letters.length; i++ )
        {
            if ( !Character.isAlphabetic( letters[i] ) )
            {
                result += letters[i];
                continue;
            }
            result += Character.toUpperCase( letters[i++] );
            while ( i < letters.length && Character.isAlphabetic( letters[i] ) )
            {
                result += letters[i++];
            }

            if ( i < letters.length )
            {
                result += letters[i];
            }
        }

        System.out.println( result ); //Напишите тут ваш код
    }

}
