package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class gatherTwoFilesIntoOne {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();

        FileInputStream in1 = new FileInputStream(name1);
        FileInputStream in2 = new FileInputStream(name2);
        reader.close();

        byte [] data1 = new byte[0];
        byte [] data2 = new byte[0];

        while (in2.available() > 0) {
            data2 = new byte[in2.available()];
            int count = in2.read(data2);
        }
        while (in1.available() > 0) {
            data1 = new byte[in1.available()];
            int count = in1.read(data1);
        }
        in2.close();
        byte [] res = new byte[data1.length + data2.length];
        FileOutputStream out = new FileOutputStream(name1);

        System.arraycopy(data2, 0, res, 0, data2.length);
        System.arraycopy(data1, 0, res, data2.length, data1.length);
        out.write(res);

        in1.close();
        out.close();
    }
}
