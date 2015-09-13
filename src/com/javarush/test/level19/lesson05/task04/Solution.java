package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
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
        while (brReader.ready()) {
            allStrings.add(brReader.readLine().replaceAll("\\.", "!"));
        }
        brReader.close();

        BufferedWriter brWriter = new BufferedWriter(new FileWriter(name2));
        for (String s : allStrings){
            brWriter.write(s);
        }
        brWriter.close();
    }
}
