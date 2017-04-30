package com.javarush.test.More.TestStudies.Latches;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Artem on 14.11.2015.
 */

public class Worker extends Thread {

    private CountDownLatch _cdl;
    private String _name;

    public Worker (CountDownLatch cdl, String name) {
        _cdl = cdl;
        _name = name;
    }

    @Override
    public void run() {
//        Stopwatch sw = new Stopwatch();
//        sw.start();

        System.out.println(_name + " working...");
        try {
            Thread.sleep(RandomGenerator.getRandom(500, 1000));
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        }
        _cdl.countDown();

//        sw.stop();
//        System.out.println(_name + " time: " + sw.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }
}