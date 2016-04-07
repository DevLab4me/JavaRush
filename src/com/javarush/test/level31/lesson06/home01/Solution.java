package com.javarush.test.level31.lesson06.home01;

import java.io.*;
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
        String filePath = "D:\\result.txt";
        String zipPath = "D:\\zip.rar";

        HashMap<ZipEntry, byte[]> zipContent = new HashMap<>();

        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(zipPath))) {
            ZipEntry zipEntry;
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

        String fileName = new File(filePath).getName();
        boolean fileAdded = false;
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath))) {
            for (Map.Entry<ZipEntry, byte[]> entry : zipContent.entrySet()) {
                if (fileName.equals(entry.getKey().getName())) {
                    addZipEntry(filePath, zipPath, fileName);
                    fileAdded = true;
                    continue;
                }
                zos.putNextEntry(entry.getKey());
                zos.write(entry.getValue());
                zos.closeEntry();
            }
        }

        if(!fileAdded){
            addZipEntry(filePath, zipPath, "new/"+fileName);
        }
    }

    public static void addZipEntry(String filePath, String zipPath, String fileName){
        try(FileInputStream fis = new FileInputStream(filePath);
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath))){
            byte[] fileBytes = new byte[fis.available()];
            fis.read(fileBytes);

            ZipEntry zipEntry = new ZipEntry(fileName);
            zos.putNextEntry(zipEntry);
            zos.write(fileBytes);
            zos.closeEntry();
        } catch (IOException ignored){}
    }
}
