package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<String> allLines = new ArrayList<>();


        BufferedReader in = new BufferedReader(new FileReader(fileName));
        while (in.ready()) {
            allLines.add(in.readLine().replaceAll("[\\p{P}]", " "));
        }
        in.close();

        int count=0;
        String[] words;
        for (String aw : allLines) {
            words = aw.split(" ");
            for (String s : words) {
                if (s.equals("world"))
                    count++;
            }
        }
        System.out.println(count);
    }
}
