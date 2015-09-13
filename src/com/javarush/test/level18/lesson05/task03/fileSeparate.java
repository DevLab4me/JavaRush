package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class fileSeparate {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream2 = new FileOutputStream(file2);
        FileOutputStream outputStream3 = new FileOutputStream(file3);
        int halfFile = inputStream.available()/2;
        while(inputStream.available() > 0){
            if (inputStream.available() > halfFile) {
                outputStream2.write(inputStream.read());
            } else {
                outputStream3.write(inputStream.read());
            }
        }
        reader.close();
        inputStream.close();
        outputStream2.close();
        outputStream3.close();
    }
}
/*if (inputStream.available() % 2 == 0){
byte [] out1 = new byte[inputStream.available()/2];
byte [] out2 = new byte[inputStream.available()/2];
int count1 = inputStream.read(out1);
int count2 = inputStream.read(out2);
outputStream2.write(out1, 0, count1);
outputStream3.write(out2, 0, count2);

} else {
byte [] out1 = new byte[inputStream.available()/2+1];
byte [] out2 = new byte[inputStream.available()/2];
int count1 = inputStream.read(out1);
int count2 = inputStream.read(out2);
outputStream2.write(out1, 0, count1);
outputStream3.write(out2, 0, count2);
}*/
/*int even = inputStream.available()/2;
            int odd = inputStream.available()/2+1;
            int totalCntByte = inputStream.available();
            if (inputStream.available()%2 == 0) {
                for (int i = 0; i < totalCntByte; i++)
                {
                    if (i < even) {
                    outputStream2.write(inputStream.read());
                    } else {
                        outputStream3.write(inputStream.read());
                    }
                }
            } else {
                for (int i = 0; i < totalCntByte; i++)
                {
                    if (i < odd) {
                        outputStream2.write(inputStream.read());
                    } else {
                        outputStream3.write(inputStream.read());
                    }
                }
            }*/