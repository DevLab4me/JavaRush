package com.javarush.test.level20.lesson04.task05;

import java.io.Serializable;

/*  ак сериализовать что-то свое?
—делайте так, чтобы сериализаци¤ класса Object была возможной
*/
public class Solution {
    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}