package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String productName = "";
        reader.close();
        if (args[0].equals("-c"))
        {
            for (int i = 1; i < args.length - 2; i++)
            {
                productName = productName + args[i] + " ";
            }
            String newProductName = setSpaces(productName, 30);
            String newPrice = setSpaces(args[args.length - 2], 8);
            String newQuantity = setSpaces(args[args.length - 1], 4);

            String id = getId(fileName);
            id = setSpaces(id, 8);
            PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
            printer.println(id + newProductName + newPrice + newQuantity);
            printer.close();
        } else {
            return;
        }
    }

    private static String getId(String fileName) throws IOException
    {
        ArrayList<Long> allIds = new ArrayList<>();
        String line;
        Long currentID;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while((line=reader.readLine())!=null) {
            line = line.substring(0, 8).replaceAll("\\s", "");
            currentID = Long.parseLong(line);
            allIds.add(currentID);
        }
        reader.close();
        Long maxID = Collections.max(allIds);
        Long myID = maxID+1;
        return myID.toString();
    }

    private static String setSpaces(String previousName, int count) {
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
