package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        ArrayList<String> allStrings = new ArrayList<>();
        ArrayList<Integer> allNums = new ArrayList<>();
        BufferedReader brReader = new BufferedReader(new FileReader(name1));
        while (brReader.ready()){
            allStrings.add(brReader.readLine());
        }
        brReader.close();

        String [] chars;
        for (String str : allStrings) {
            chars = str.split(" ");
            for (String s : chars)
            {
                try {
                    allNums.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    //NOP
                }
            }
        }
        BufferedWriter brWriter = new BufferedWriter(new FileWriter(name2));
        for (Integer number : allNums) {
            brWriter.write(number + " ");
        }
        brWriter.close();
    }
}
