package com.javarush.test.More.TestStudies.Latches;

/**
 * Created by Artem on 14.11.2015.
 */

public class RandomGenerator {
    public static long getRandom(long min, long max) {
        return min + (long)(Math.random() * (max - min + 1));
    }
}
