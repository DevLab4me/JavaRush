package com.javarush.test.More.TestStudies;

/**
 * Created by Artem on 08.11.2015.
 */

public class throwNullException {
    public static void main(String[] args) {
        RuntimeException re = null;
        throw re;
    }
}
