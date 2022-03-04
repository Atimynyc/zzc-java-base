package com.zzc.juc.multidemo;

public class RunnableShareTest {

    public static void main(String[] args) {
        // 当传的是同一个runnable，那么会共享同一个runnable的变量
        Runnable runnableA = new ShareRunnable();
        Runnable runnableB = new ShareRunnable();
        runnableA.run();
        runnableB.run();



        Thread threadC = new ShareThread();
        Thread threadD = new Thread(threadC, "D");
        Thread threadE = new Thread(threadC, "E");
        threadD.start();
        threadE.start();

    }

}

class ShareRunnable implements Runnable {

    private int i = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " +i++);
    }
}

class ShareThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " +i++);
    }
}

