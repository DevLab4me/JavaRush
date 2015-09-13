package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class FindMinByte {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int min = 1000;
        while (inputStream.available() > 0) {
            int tmp = inputStream.read();
            if (tmp < min) {
                min = tmp;
            }
        }
        System.out.println(min);
        reader.close();
        inputStream.close();
    }
}
