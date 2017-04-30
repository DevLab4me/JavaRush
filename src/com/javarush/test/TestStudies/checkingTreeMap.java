package com.javarush.test.More.TestStudies;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Artem on 24.11.2015.
 */

public class checkingTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeMap<Integer, Integer> dmap = new TreeMap<>();
        map.put(1, 2);
        map.put(10, 7);
        map.put(112, 8);
        map.put(75, 3);
        dmap.putAll(map.descendingMap());
        map.descendingMap();
//        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
        System.out.println(map.get(10));
        map.put(10, map.get(10) - 1);
        System.out.println(map.get(10));

//        while (!dmap.get(10).equals(4)){
//            int count = map.get(10);
//            System.out.println("Value is: " + count);
//            count--;
//
//            map.put(10, count);
//            System.out.println(dmap.get(10));
//        }
    }
    public static void reduceCount(TreeMap<Integer, Integer> map, int number)
    {
        int count = map.get(number);
        count--;
        map.put(map.get(number), count);
    }
}
