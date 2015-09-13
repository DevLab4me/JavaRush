package com.javarush.test.level03.lesson12.home01;

/* Жить хорошо, а хорошо жить еще лучше
Вывести на экран надпись «Жить хорошо, а хорошо жить еще лучше»
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LifeIsGood
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int time = Integer.parseInt(reader.readLine());

        System.out.println(name + " захватит мир через " + time + " лет. Му-ха-ха!");
    }
}
