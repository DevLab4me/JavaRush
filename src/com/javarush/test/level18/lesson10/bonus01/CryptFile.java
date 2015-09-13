package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CryptFile {
    private static final byte key = 10;
    public static void main(String[] args) throws IOException {
        if (args.length < 3){
            return;
        }
        FileInputStream in = new FileInputStream(args[1]);
        FileOutputStream out = new FileOutputStream(args[2]);

        while (in.available() > 0) {
            byte [] buff = new byte[in.available()];
            in.read(buff);
            out.write(crypt(buff));
        }

    }

    private static byte[] crypt(byte[] buff)
    {
        byte [] res = new byte[buff.length];
        for (int i = 0; i < buff.length; i++)
        {
            res[i] = (byte)(buff[i] ^ key);
        }
        return res;
    }
}
