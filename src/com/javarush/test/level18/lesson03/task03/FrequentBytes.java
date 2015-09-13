package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class FrequentBytes {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String res = "";
        FileInputStream in = new FileInputStream(fileName);
        ArrayList<Integer> allBytes = new ArrayList<>();
        ArrayList<Integer> sameBytes = new ArrayList<>();

        while (in.available() > 0) {
            allBytes.add(in.read());
        }

        int [] countRepetition = new int[allBytes.size()];

        for (int i = 0; i < allBytes.size(); i++)
        {
            countRepetition[i] = 0;
            for (int j = 0; j < allBytes.size(); j++)
            {
                if (allBytes.get(i) == allBytes.get(j)) countRepetition[i]++;
            }
        }

        int max = Integer.MIN_VALUE;

        for (int h : countRepetition) {
            if (h > max) max = h;
        }
        System.out.println(max);
        for (int i = 0; i < allBytes.size(); i++)
        {
            if(!sameBytes.contains(allBytes.get(i))&&countRepetition[i]==max)
            sameBytes.add(allBytes.get(i));
        }
        System.out.println("Size "+sameBytes.size());
        for (int y : sameBytes) {
            res = y + " ";
        }

        System.out.println(res);
        int num = Integer.parseInt(res.trim());
        System.out.println("Answer is:"+(char)num+":Now we see it");
        reader.close();
        in.close();
    }
}
