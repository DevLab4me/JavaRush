package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }

        File name1 = new File(args[0]);
        FileInputStream in = new FileInputStream(name1);

        TreeMap<Character, Integer> symbols = new TreeMap<>();
        byte [] data;
        char [] chars = new char[0];
        while (in.available() > 0){
            data = new byte[in.available()];
            int r = in.read(data);
            chars = new String(data).toCharArray();
        }
        in.close();

        for (char b : chars) {
            if (symbols.containsKey(b)) {
                int val = symbols.get(b) + 1;
                symbols.put(b, val);
            } else {
                symbols.put(b, 1);
            }
        }
        for (Map.Entry<Character, Integer> map : symbols.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }
}
