package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 5 слов в обратном порядке
Введи с клавиатуры 5 слов в список строк. Выведи их в обратном порядке.
*/

public class Solution
{
    final static int W = 5;
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < W; i++){
        list.add(reader.readLine());//Напишите тут ваш код
        }
        for (int i = 0; i < list.size(); i++){
            int j = list.size() - i - 1;
            System.out.println(list.get(j));
        }
    }
}
