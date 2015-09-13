package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;
import java.util.ArrayList;

public class reverseWrite {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        ArrayList<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0) {
             list.add(inputStream.read());
        }
        for (int i = list.size()-1; i >= 0; i--)
        {
             outputStream.write(list.get(i));
        }
        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
