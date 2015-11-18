package com.javarush.test.level27.lesson04.task02;

/* Второй вариант дедлока
В методе secondMethod в синхронизированных блоках расставьте локи так,
чтобы при использовании класса Solution нитями образовывался дедлок
*/
public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (this) {
                doSomething();
            }
        }
    }

    private void doSomething() {
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.firstMethod();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.secondMethod();
            }
        });
        thread1.start();
        thread2.start();
    }
}