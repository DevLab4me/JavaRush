package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        ArrayList<Integer> list = new ArrayList<>();
        FileReader in = new FileReader(name1);

        while (in.ready()){
            list.add(in.read());
        }
        in.close();

        FileWriter out = new FileWriter(name2);
        for (int i = 1; i < list.size(); i=i+2)
        {
            out.write((char)(int)list.get(i));
        }
        out.close();
    }
}
