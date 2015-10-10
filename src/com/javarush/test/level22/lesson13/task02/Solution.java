package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
//        String fileName = "d:\\testFile.txt";
//        String fileName2 = "d:\\result.txt";
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        List<String> allStrings = new ArrayList<>();
        while (fileReader.ready())
            allStrings.add(fileReader.readLine());
        fileReader.close();

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        FileOutputStream printWriter = new FileOutputStream(args[1]);
        for (String currentLine : allStrings) {
            byte[] line = currentLine.getBytes();
            String str = new String(line, utf8);
            line = str.getBytes(windows1251);
            printWriter.write(line);
        }
        printWriter.close();
    }
}