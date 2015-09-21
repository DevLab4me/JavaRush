package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFile = args [0];
        String secondFile = args [1];
        ArrayList<String> allStrings = new ArrayList<>();
        ArrayList<String> bigWords = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(firstFile));
        String input;
        while ((input=bufferedReader.readLine()) != null) {
             allStrings.add(input);
        }
        bufferedReader.close();

        for (String oneString : allStrings) {
            String [] strArray = oneString.split(" ");
            for (String word : strArray)
                if (word.length()>6)
                    bigWords.add(word);
        }

        StringBuilder oneString = new StringBuilder();
        for (int i = 0; i < bigWords.size(); i++)
        {
            if (i == bigWords.size()-1)
                oneString.append(bigWords.get(i));
            else
                oneString.append(bigWords.get(i) + ",");
        }
        String result = oneString.toString();
        PrintWriter  printWriter = new PrintWriter (new FileWriter(secondFile));
        printWriter.write(result);
        printWriter.close();
    }
}
