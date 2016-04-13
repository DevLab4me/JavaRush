package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("D:\\result.txt");
        Path zipPath = Paths.get("D:\\zip.rar");

        Map<ZipEntry, byte[]> zipContent = new HashMap<>();

        try(InputStream is = Files.newInputStream(zipPath);
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(is))) {
            ZipEntry zipEntry;
            System.out.println(zis.getNextEntry()!=null);
            while ((zipEntry = zis.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;
                while ((count = zis.read(buffer)) != -1) {
                    baos.write(buffer, 0, count);
                }
                zipContent.put(zipEntry, baos.toByteArray());
            }
        }

        try(OutputStream os = Files.newOutputStream(zipPath);
            ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(os))) {
            for (Map.Entry<ZipEntry, byte[]> entry : zipContent.entrySet()) {
                if (entry.getKey().getName().equals(filePath.toFile().getName())) {
                    InputStream inputStream = Files.newInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count;
                    while ((count = inputStream.read(buffer)) != -1) {
                        baos.write(buffer, 0, count);
                    }
                    byte[] bytes = baos.toByteArray();
                    zos.putNextEntry(entry.getKey());
                    zos.write(bytes);
                    zos.closeEntry();
                    inputStream.close();
                }else {
                    zos.putNextEntry(entry.getKey());
                    zos.write(entry.getValue());
                    zos.closeEntry();
                }
            }
        }
    }
}
