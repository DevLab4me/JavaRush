package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String productName = "";
        reader.close();

        ArrayList<String> listStrings = getStringList(fileName);
        ArrayList<Long> listIds = getIdList(fileName);
        PrintWriter printerWriter;
        int index = listIds.indexOf(Long.parseLong(args[1]));

        if(args[0].equals("-u")) {
            for (int i = 2; i < args.length - 2; i++)
            {
                productName = productName+args[i] + " ";
            }
            String newProductName = setSpaces(productName, 30);
            String newPrice = setSpaces(args[args.length-2], 8);
            String newQuantity = setSpaces(args[args.length-1], 4);
            String id = setSpaces(args[1], 8);
            String ourString = id + newProductName + newPrice + newQuantity;
            if (!(listIds.contains(Long.parseLong(args[1])))) {
                printerWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
                printerWriter.println(ourString);
            } else {
                listStrings.set(index, ourString);
                printerWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
                for (String s : listStrings) {
                    printerWriter.println(s);
                }
            }
            printerWriter.close();
        } else if (args[0].equals("-d")) {
            listStrings.remove(index);
            printerWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            for (String s : listStrings) {
                printerWriter.println(s);
            }
            printerWriter.close();
        } else {
            return;
        }
    }

    private static ArrayList<String> getStringList(String fileName) throws IOException
    {
        ArrayList<String> allStrings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while((line=reader.readLine()) != null) {
            allStrings.add(line);
        }
        reader.close();
        return allStrings;
    }

    private static ArrayList<Long> getIdList (String fileName)  throws IOException
    {
        ArrayList <Long> allIds = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        Long id;
        while((line=reader.readLine()) != null) {
            line = line.substring(0, 8).replaceAll("\\s", "");
            id = Long.parseLong(line);
            allIds.add(id);
        }
        reader.close();
        return allIds;
    }

    private static String setSpaces(String previousName, int count)
    {
        String newName;
        if (previousName.length() > count) {
            newName = previousName.substring(0, count);
        } else {
            String s = "";
            for (int i = 0; i < (count - previousName.length()); i++)
                s += " ";
            newName = previousName+s;
        }
        return newName;
    }
}
