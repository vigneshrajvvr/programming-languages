package com.vvr.concurrency;

import java.math.BigInteger;

public class ThreadLifeCycle {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Task1());
        System.out.println(thread1.getState()); // NEW
        thread1.start();
        System.out.println(thread1.getState());
        Thread.sleep(1000);// RUNNABLE/TERMINATED
        System.out.println(thread1.getState()); // TERMINATED

        Thread thread2 = new Thread(new Task2());
        Thread thread3 = new Thread(new Task2());
        thread2.start();
        thread3.start();
        System.out.println(thread2.getState());
        System.out.println(thread3.getState());
        Thread.sleep(2000);
        System.out.println(thread2.getState()); // TIMED_WAITING
        System.out.println(thread3.getState()); // TIMED_WAITING

        Thread thread6 = new Thread(new Task4());
        thread6.start();
        Thread.sleep(1000);
        System.out.println("Waiting : " + thread6.getState()); // WAITING

        Thread thread4 = new Thread(new Task3());
        Thread thread5 = new Thread(new Task3());
        thread4.start();
        thread5.start();
        Thread.sleep(2000);
        System.out.println(thread4.getState()); // RUNNABLE
        System.out.println(thread5.getState()); // BLOCKED

    }
}

class Task4 implements Runnable{
    @Override
    public void run() {
        Thread currentThread = new Thread(new Task5());
        currentThread.start();
        try {
            currentThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Task5 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Task1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Task 1");
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        try {
            commonResource();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void commonResource() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(10000);
            System.out.println("Common Resource");
        }
    }
}

class Task3 implements Runnable {

    @Override
    public void run() {
        commonResource();
    }

    public static synchronized void commonResource() {
        while(true) {

        }
    }
}

