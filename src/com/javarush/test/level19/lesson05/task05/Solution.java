package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
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

        BufferedReader brReader = new BufferedReader(new FileReader(name1));
        while (brReader.ready()){
            allStrings.add(brReader.readLine());
        }
        brReader.close();

        BufferedWriter brWriter = new BufferedWriter(new FileWriter(name2));
        String line;
        for (String str : allStrings) {
            line = str.replaceAll("[\\p{P}]", "");
            brWriter.write(line);
        }
        brWriter.close();
    }
}
