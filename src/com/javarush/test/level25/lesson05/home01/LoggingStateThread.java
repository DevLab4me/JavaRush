package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Artem on 20.10.2015.
 */

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state = this.thread.getState();
        System.out.println(state);
        while(state != State.TERMINATED){
            if (state != this.thread.getState())
            {
                state = this.thread.getState();
                System.out.println(state);
            }
        }
    }
}
