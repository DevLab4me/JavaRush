package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));// напишите тут ваш код

        List<Integer> numbers = new ArrayList<Integer>();

       while(reader.ready())
       {
           int nextNumber = Integer.parseInt(reader.readLine());
           if (nextNumber % 2 == 0)
           {
               numbers.add(nextNumber);
           }
       }
           reader.close();
           sort(numbers);

           for (int x : numbers)
           {
               System.out.println(x);
           }

    }

    private static void sort(List<Integer> numbers)
    {
        for (int i = 0; i < numbers.size(); i++)
        {
            for (int j = 0; j < numbers.size() - i - 1; j++)
            {
                int tmp = numbers.get(i);
                numbers.set(j, numbers.get(j + 1));
                numbers.set(j +1, tmp);
            }
        }
    }
}
