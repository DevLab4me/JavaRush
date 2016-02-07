package com.javarush.test.More.TestStudies;

/**
 * Created by Artem on 08.11.2015.
 */

public class forLoopContinueLabel {
    public static void main(String[] args) {
        int count = 0;
        outerLabel:
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++)
            {
                count++;
                if(count > 2) {
                    break outerLabel;
                }
            }
            count += 10;
        }
        System.out.println(count);
    }
}
