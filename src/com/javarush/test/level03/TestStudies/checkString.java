package com.javarush.test.More.TestStudies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Artem on 24.11.2015.
 */

public class checkString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countLines = 0;
        while(true){
            String line = reader.readLine();
            if(line.length() == 6){
                if(line.replaceAll("[0-1]","").length()==0){
                    System.out.println("all good!");
                }
                countLines++;

                if(countLines == 3)
                    break;
            } else
                System.out.println("Please, try again. String length should be the same as a width of the wall");
        }
    }
}
