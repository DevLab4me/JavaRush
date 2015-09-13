package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class RareBytes {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String res = " ";
        FileInputStream inputStream = new FileInputStream(fileName);
        ArrayList<Integer> fileBytes = new ArrayList<>();
        ArrayList<Integer> rareBytes = new ArrayList<>();

        while(inputStream.available() > 0) {
            fileBytes.add(inputStream.read());
        }
        int [] count = new int[fileBytes.size()];
        for (int i = 0; i < fileBytes.size(); i++)
        {
            count[i] = 0;
            for (int j = 0; j < fileBytes.size(); j++)
            {
                if (fileBytes.get(i)==fileBytes.get(j)) count[i]++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int y : count) {
            if (y < min)  min = y;
        }
        for (int i = 0; i < fileBytes.size(); i++)
        {
            if (!rareBytes.contains(fileBytes.get(i))&&count[i]==min) rareBytes.add(fileBytes.get(i));
        }
        for (int x : rareBytes) {
            res = x + " ";
            System.out.println(res);
        }

        reader.close();
        inputStream.close();
    }
}
