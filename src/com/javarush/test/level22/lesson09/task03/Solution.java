package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн
Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //...
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        ArrayList<String> allWords = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready())
        {
            String[] s = reader.readLine().split("\\s");
            Collections.addAll(allWords, s);
        }
        reader.close();
        String[] words = new String[allWords.size()];
        words = allWords.toArray(words);
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
        scanner.close();
    }

    public static StringBuilder getLine(String... words)
    {
        if (words == null || words.length == 0)
        { return new StringBuilder(); }

        StringBuilder result = new StringBuilder();

        ArrayList<String> allWords = new ArrayList<>();
        Collections.addAll(allWords, words);

        while (!isOK(allWords))
        {
            Collections.shuffle(allWords);
        }
        for (String currentWord : allWords) {
            if(currentWord.equals(""))
                result.append(currentWord);
            else
                result.append(" ").append(currentWord);
        }
        return result;
    }
    public static boolean isOK(ArrayList<String> list)
    {
        for (int i = 0; i < list.size()-1; i++)
        {
            String firstWord = list.get(i);
            String secondWord = list.get(i+1);
            firstWord = firstWord.toLowerCase();
            secondWord = secondWord.toLowerCase();
            if (firstWord.charAt(firstWord.length()-1)!=secondWord.charAt(0))
                return false;
        }
        return true;
    }
}