package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpacesFrequency {
    public static void main(String[] args) throws IOException
    {
        int count = 0;
        int spaces = 0;
        double res;
        if (args.length > 0) {
            FileInputStream in = new FileInputStream(args[0]);

            while (in.available() > 0 ) {
                count++;
                int data = in.read();
                if (data == (int) ' ') {
                    spaces++;
                }
            }
            in.close();
            res = (double) spaces / count * 100;
            double result = new BigDecimal(res).setScale(2, RoundingMode.UP).doubleValue();
            System.out.println(result);
        }
    }
}
