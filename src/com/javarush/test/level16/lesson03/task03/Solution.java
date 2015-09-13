package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread one = new SpecialThread();
        SpecialThread two = new SpecialThread();
        SpecialThread three = new SpecialThread();
        SpecialThread four = new SpecialThread();
        SpecialThread five = new SpecialThread();
//        Thread thr1 = new Thread(one);
//        Thread thr2 = new Thread(two);
//        Thread thr3 = new Thread(three);
//        Thread thr4 = new Thread(four);
//        Thread thr5 = new Thread(five);
        //Add your code here - добавьте свой код тут
        list.add(new Thread(one));
        list.add(new Thread(two));
        list.add(new Thread(three));
        list.add(new Thread(four));
        list.add(new Thread(five));
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
