package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFile = args[0];
        String secondFile = args[1];
        ArrayList<String> allStrings = new ArrayList<>();

        BufferedReader fileReader = new BufferedReader(new FileReader(firstFile));
        String input;
        while ((input=fileReader.readLine()) != null) {
             allStrings.add(input);
        }
        fileReader.close();

        ArrayList<String > wordsWithNums = new ArrayList<>();
        for (String oneString : allStrings) {
            String [] line = oneString.split(" ");
            for (String word : line) {
                if (word.matches(".*\\d.*"))
                    wordsWithNums.add(word);
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(secondFile));
        for (String word : wordsWithNums) {
            writer.write(word + " ");
        }
        writer.close();
    }
}
