package com.urise.webapp;

import java.util.ArrayList;
import java.util.List;

public class MainConcurrency {
    public static final int THREADS_NUMBER = 10000;
    private static int counter;
    private static final Object LOCK = new Object();

    private void count() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread1 = new Thread() {
            public void run() {
                System.out.println(getName() + ", " + getState());
            }
        };
        thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getState());
            }
        }).start();

        MainConcurrency mainConcurrency1 = new MainConcurrency();
//        MainConcurrency mainConcurrency2 = new MainConcurrency();
//        deadLock(mainConcurrency1, mainConcurrency2);
        List<Thread> threadList = new ArrayList<>(THREADS_NUMBER);
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 100; j++) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mainConcurrency1.count();
                    }
                });
                thread.start();
                threadList.add(thread);
                for (Thread t : threadList) t.join();
            }
        }
        System.out.println(counter);
    }

    public static void deadLock(MainConcurrency obj1, MainConcurrency obj2) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1) {
                    obj1.count();
                    System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2) {
                        System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
                        obj2.count();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2) {
                    obj2.count();
                    System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1) {
                        System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
                        obj1.count();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
