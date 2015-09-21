package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<String> allStrings = new ArrayList<>();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String input;
        while ((input=fileReader.readLine()) != null) {
            allStrings.add(reverseLine(input));
        }
        fileReader.close();

        for (String line : allStrings) {
            System.out.println(line);
        }
    }

    private static String reverseLine(String input)
    {
        String result="";
        String [] strBytes = input.split("");
        for (int i = strBytes.length-1; i >= 0; i--)
        {
            result = result+strBytes[i];
        }
        return result;
    }
}
