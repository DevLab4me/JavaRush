package com.javarush.test.More.TestStudies;

/**
 * Created by Artem on 24.11.2015.
 */

public class checkingSpacePosition {
    public static void main(String[] args) {
        String line = " 6 3 45";
        int res = getIntegerFromString(line, 3);
        System.out.println(res);
    }

    public static int getIntegerFromString(String line, int index) //Function which parses given string to find
    //number in it. Index can be 1 or 2 which allows finding first or second integer in this string
    {
        String substring;
        String [] numbers = line.trim().split(" ");
        int spacePosition = line.indexOf(" ");
        System.out.println("Space Position: " + spacePosition) ;
//        if (spacePosition == 0) {
//            if (index == 1) substring = line;
//            else throw new IndexOutOfBoundsException("Index can be from 1 to 3");
//        } else {
            if (index == 1) substring = numbers[0];
            else if (index == 2) substring = numbers[1];
            else if (index == 3) substring = numbers[2];
            else throw new IndexOutOfBoundsException("Index can be from 1 to 3");

        return Integer.parseInt(substring.trim());
    }
}
