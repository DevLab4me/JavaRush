package com.javarush.test.More.TestStudies.Latches;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Artem on 14.11.2015.
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Stopwatch sw = new Stopwatch();
//        sw.start();

        CountDownLatch latch = new CountDownLatch(4);

        new Worker(latch,"Sand").start();
        new Worker(latch,"Cement").start();
        new Worker(latch,"Water").start();
        new Worker(latch,"Breakstone").start();

        System.out.println("Waiting for all workers");
        latch.await();
        System.out.println("All workers finished. Now we can shake.");

//        sw.stop();
//        System.out.println("Program time: " + sw.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }
}
