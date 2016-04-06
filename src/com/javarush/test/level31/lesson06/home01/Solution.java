package com.javarush.test.level31.lesson06.home01;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
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
        String pathToFile = args[0];
        String pathToZip = args[1];

        HashMap<String, byte[]> zipContent = new HashMap<>();

        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(pathToZip))) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;
                while ((count = zis.read(buffer)) != -1) {
                    baos.write(buffer, 0, count);
                }
                String filename = zipEntry.getName();
                byte[] bytes = baos.toByteArray();
                zipContent.put(filename, bytes);
            }
        }

        String fileName = Paths.get(pathToFile).getFileName().toString();
        try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(pathToFile))) {
            for (Map.Entry<String, byte[]> fileEntry : zipContent.entrySet()) {
                if (!fileEntry.getKey().equals(fileName)) {
                    zip.putNextEntry(new ZipEntry(fileEntry.getKey()));
                    zip.write(fileEntry.getValue());
                }
                zip.putNextEntry(new ZipEntry("new/" + Paths.get(fileName).getFileName()));
                Files.copy(Paths.get(pathToFile), zip);
            }
        }
    }
}
