package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) {
        File resultFileName = new File(args[0]);
        List<File> zipFiles = new ArrayList<>();

        for(int i = 1; i < args.length; i++){
            zipFiles.add(new File(args[i]));
        }

        Collections.sort(zipFiles);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];

        for(File file : zipFiles) {
            try (FileInputStream fis = new FileInputStream(file)){
                while ((fis.read(buffer)) > -1) {
                    baos.write(buffer);
                    baos.flush();
                }
            } catch (IOException ignored) {}
        }

        try(ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(baos.toByteArray()));
            FileOutputStream fos = new FileOutputStream(resultFileName)) {
            while(zis.getNextEntry()!=null){
                int count;
                while ((count = zis.read(buffer)) != -1) {
                    fos.write(buffer, 0, count);
                }
            }
        } catch (IOException ignored){}
    }
}
