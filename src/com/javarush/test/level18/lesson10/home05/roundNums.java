package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class roundNums {
    public static void main(String[] args) throws IOException
    {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            File name1 = new File(reader.readLine());
            File name2 = new File(reader.readLine());
            FileInputStream in = new FileInputStream(name1);
            FileOutputStream out = new FileOutputStream(name2);

            while (in.available() > 0) {
                byte [] data = new byte[in.available()];
                int r = in.read(data);
                out.write(getNums(data));
            }
        reader.close();
        in.close();
        out.close();
    }

    private static byte[] getNums(byte[] data)
    {
        StringBuilder builder = new StringBuilder(data.length);
        String [] elem = new String(data).split(" ");
        byte [] result;
        long [] tmp = new long[elem.length];

        for (int i = 0; i < elem.length; i++)
        {
            tmp[i] = Math.round(Double.valueOf(elem[i]));
        }
        for (int i = 0; i < tmp.length; i++)
        {
            if (i == tmp.length-1) {
                builder.append(tmp[i]);
            } else {
                builder.append(tmp[i]);
                builder.append(" ");
                builder.trimToSize();
            }
        }
        result = builder.toString().getBytes();
        return result;
    }
}