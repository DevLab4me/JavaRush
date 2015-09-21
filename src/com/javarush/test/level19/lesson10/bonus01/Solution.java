package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<>();
    public static List<String> file1Lines = new ArrayList<>();
    public static List<String> file2Lines = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        reader.close();

        BufferedReader file1Reader = new BufferedReader(new FileReader(firstFile));
        BufferedReader file2Reader = new BufferedReader(new FileReader(secondFile));
        
        while (file1Reader.ready())
            file1Lines.add(file1Reader.readLine());
        file1Reader.close();

        while (file2Reader.ready())
            file2Lines.add(file2Reader.readLine());
        file2Reader.close();

        int zero1 = 0, zero2 = 0;
        boolean list1Empty = false;
        boolean list2Empty = false;

        while (true)
        {
            if (zero1 >= file1Lines.size())
                list1Empty = true;
            if (zero2 >= file2Lines.size())
                list2Empty = true;

            //Only 1st list is empty.
            if (list1Empty && !list2Empty)
            {
                if (lines.get(lines.size() - 1).type.equals(Type.SAME)) {
                    lines.add(new LineItem(Type.ADDED, file2Lines.get(zero2)));
                    break;
                } else
                    return;
            }
            //Only 2nd list is empty.
            if (list2Empty && !list1Empty)
            {
                if (lines.get(lines.size() - 1).type.equals(Type.SAME)) {
                    lines.add(new LineItem(Type.REMOVED, file1Lines.get(zero1)));
                    break;
                } else
                    return;
            }
            //Both lists are empty.
            if (list1Empty && list2Empty)
                break;

            //if SAME
            if (file1Lines.get(zero1).equals(file2Lines.get(zero2)))
            {
                lines.add(new LineItem(Type.SAME, file1Lines.get(zero1)));

                if (zero1 < file1Lines.size())
                    zero1++;
                else
                    list1Empty = true;

                if (zero2 < file2Lines.size())
                    zero2++;
                else
                    list2Empty = true;
            }

            //if not SAME
            else if (!list1Empty && !list2Empty)
            {
                //if line was ADDED
                if ((zero2 + 1 < file2Lines.size()) && file1Lines.get(zero1).equals(file2Lines.get(zero2 + 1)))
                {
                    lines.add(new LineItem(Type.ADDED, file2Lines.get(zero2)));
                    lines.add(new LineItem(Type.SAME, file1Lines.get(zero1)));

                    if (zero1 < file1Lines.size())
                        zero1++;
                    else
                        list1Empty = true;

                    if (zero2 < file2Lines.size())
                        zero2++;
                    else
                        list2Empty = true;

                    if (zero2 < file2Lines.size())
                        zero2++;
                    else
                        list2Empty = true;
                }
                //if line was REMOVED
                else if ((zero1 + 1 < file1Lines.size()) && file2Lines.get(zero2).equals(file1Lines.get(zero1 + 1)))
                {
                    lines.add(new LineItem(Type.REMOVED, file1Lines.get(zero1)));
                    lines.add(new LineItem(Type.SAME, file2Lines.get(zero2)));

                    if (zero1 < file1Lines.size())
                        zero1++;
                    else
                        list1Empty = true;

                    if (zero1 < file1Lines.size())
                        zero1++;
                    else
                        list1Empty = true;

                    if (zero2 < file2Lines.size())
                        zero2++;
                    else
                        list2Empty = true;
                }
            }
        }

        for (LineItem line : lines)
            System.out.printf("%s %s%n", line.type, line.line);
    }

    public static enum Type
    {
        ADDED,        //added new line
        REMOVED,      //removed line
        SAME          //no changes
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}