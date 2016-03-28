package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path folderName = Paths.get(args[0]);
        Path resultFilePath = Paths.get(args[1]);
        Stack<File> folderContent = new Stack<>();
        Collections.addAll(folderContent, folderName.toFile().listFiles());

        LinkedList<File> files = new LinkedList<>();
        while(!folderContent.isEmpty()) {
            File folderFile = folderContent.pop();

            if(folderFile.isDirectory()) {
                if(folderFile.listFiles().length > 0) {
                    Collections.addAll(folderContent, folderFile.listFiles());
                }else
                    folderFile.delete();
            } else {
                if(!folderFile.equals(resultFilePath.toFile())) {
                    if (folderFile.length() > 50) {
                        folderFile.delete();
                    } else {
                        files.add(folderFile);
                    }
                }
            }
        }
        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
                }
            });

            Path newResPath = Files.move(resultFilePath, resultFilePath.resolveSibling("allFilesContent.txt"));

            try {
                FileReader fileReader;
                FileWriter fileWriter = new FileWriter(newResPath.toFile());

                for (File file : files) {
                    fileReader = new FileReader(file);
                    while (fileReader.ready()) {
                        fileWriter.write(fileReader.read());
                    }
                    fileWriter.write("\r\n");
                    fileReader.close();
                }
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.getMessage();
            }
    }
}
