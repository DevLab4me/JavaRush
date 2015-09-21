package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        TreeMap<String, Double> dataMap = new TreeMap<>();

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String [] split = line.split(" ");
            if (dataMap.containsKey(split[0])) {
                double sum = dataMap.get(split[0])+Double.parseDouble(split[1]);
                dataMap.put(split[0], sum);
            } else
            {
                dataMap.put(split[0], Double.parseDouble(split[1]));
            }
        }
        fileReader.close();
        for(Map.Entry<String, Double> pair : dataMap.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
