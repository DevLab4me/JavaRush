package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Artem on 30.01.2016.
 */

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            for (int i = 1; i < 10; i++) {
                queue.offer(new ShareItem(String.format("ShareItem-%d"+i), i));
                System.out.format("Элемент %s-%d добавлен %n", "ShareItem-", i);
                Thread.sleep(100);

                if(queue.hasWaitingConsumer())
                    System.out.println("Consumer в ожидании!");
            }
        } catch (InterruptedException ignored) {}
    }
}
