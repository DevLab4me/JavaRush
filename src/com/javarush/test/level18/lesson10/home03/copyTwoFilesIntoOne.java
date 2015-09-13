package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class copyTwoFilesIntoOne {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();
        FileInputStream in = new FileInputStream(name2);
        FileInputStream in2 = new FileInputStream(name3);
        FileOutputStream out = new FileOutputStream(name1);

        while (in.available() > 0) {
            byte [] res = new byte[in.available()];
            int count = in.read(res);
            out.write(res, 0, count);
        }

        while (in2.available() > 0) {
            byte [] res = new byte[in2.available()];
            int count = in2.read(res);
            out.write(res, 0, count);
        }
        reader.close();
        in.close();
        in2.close();
        out.close();
    }
}
