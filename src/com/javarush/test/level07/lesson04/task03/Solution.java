package com.javarush.test.level07.lesson04.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 2 массива
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк, индекс/номер ячейки которой совпадает с текущим индексом из массива чисел. Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    final static int LINES_QTY = 10; //Кол-во строк в массивах

    public static void main( String[] args ) throws Exception
    {
        String[] s = new String[LINES_QTY];
        int[] n = new int[LINES_QTY];
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        for ( int i = 0; i < s.length; i++ )
        {
            s[i] = br.readLine();
            n[i] = s[i].length();
        }

        System.out.println();
        for ( int i = 0; i < s.length; i++ )
        {
            System.out.println( n[i] );
        }
    }
}
