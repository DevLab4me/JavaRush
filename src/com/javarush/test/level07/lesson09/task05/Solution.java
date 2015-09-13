package com.javarush.test.level07.lesson09.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удвой слова
1. Введи с клавиатуры 10 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. Используя цикл for выведи результат на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        //read strings and init ArrayList list here - считать строки с консоли и объявить ArrayList list тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        ArrayList<String> result = doubleValues(list);

        //print result - вывести на экран result
        for (String entry: result) {
            System.out.println(entry);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {

        ArrayList<String> list1 = new ArrayList<String>();
        for (String value: list) {
            list1.add(value);
            list1.add(value);
        }
        return list1;

    }
}
 /*  Other Variants for the method doubleValues:
         for(int i = 0; i < list.size(); ){
            list.set(i, list.get(i) + list.get(i));
            i++;
        }

        return  list;*/

       /* ArrayList<String> list1 = new ArrayList<String>();
        for (int i = 0; i < 10;i++) {
            list1.add(list.get(i) + list.get(i));

        }
        return list1;
        }*/

       /* int i = 0;
        for (String value: list) {
            list.set(i, value + value);
            i++;
        }

        return list;*/

        /*ArrayList<String> list1 = new ArrayList<String>();
        for (String value: list) {
            list1.add(value + value);
        }
        return list1;*/



        /*ArrayList<String> list1 = new ArrayList<String>();
        String s;
        for (int i = 0; i < 10; i++) {
            s = list.get(i);
            list1.add(s);
            list1.add(s);
        }

        return list1;*/