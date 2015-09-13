package com.javarush.test.level07.lesson06.task05;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    final static int NUMBERS_QTY = 5;
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < NUMBERS_QTY; i++){
            list.add( br.readLine() );
        }
        for (int i = 0; i < 13; i++){
            list.add(0, list.remove(NUMBERS_QTY - 1));
        }
        for (String s: list)
        {
            System.out.println(s);
        }//Напишите тут ваш код

    }
}
