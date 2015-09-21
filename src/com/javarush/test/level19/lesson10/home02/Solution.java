package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
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

        String richMan="";
        double max = Double.MIN_VALUE;
        for(Map.Entry<String, Double> pair : dataMap.entrySet()) {
            if (pair.getValue() > max) {
                max = pair.getValue();
                richMan = pair.getKey();
            }
        }
        System.out.println(richMan);
    }
}
