package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Artem on 07.02.2016.
 */

public class BinaryRepresentationTask extends RecursiveTask {
    private int num;
    public BinaryRepresentationTask(int i) {
        this.num = i;
    }

    @Override
    protected String compute() {
        int a = num % 2;
        int b = num / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            return task.join() + result;
        }
        return result;
    }
}
