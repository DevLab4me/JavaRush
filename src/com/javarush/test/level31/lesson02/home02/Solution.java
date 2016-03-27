package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> fileList = getFileTree("D:\\Learning Java\\JavaRush");
        for (String s : fileList) {
            System.out.println(s);
        }
    }

    public static List<String> getFileTree(String root) throws IOException {
        List<String> resultList = new ArrayList<>();
        Stack<File> folderContent = new Stack<>();

        File folder = new File(root);
        Collections.addAll(folderContent, folder.listFiles());

        while (!folderContent.isEmpty()){
            File childFolder = folderContent.pop();

            if (childFolder.isDirectory()){
                for (File file : childFolder.listFiles()){
                    folderContent.push(file);
                }
            } else
                resultList.add(childFolder.getAbsolutePath());
        }
        return resultList;

    }
}
