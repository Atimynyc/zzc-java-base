package com.zzc.juc.multidemo;

/**
 * @description: 启动a、b两个线程，有这个两个线程打印处1到100共一百个数字，要求a线程打印1、3、5。。。。。，要求b线程打印2、4、6。。。。
 *               直到100
 * @author: Atimynyc
 * @Date: 2021/10/31
 **/
public class TwoThreadAlternate2 {

    private static int count = 1;

    private static final Object lock = new Object();

    static class MyRunnerable1 implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                while (count <= 100) {
                    if (count % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "-" + count++);
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class MyRunnerable2 implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                while (count <= 100) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "-" + count++);
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnerable1(), "a");
        Thread thread2 = new Thread(new MyRunnerable2(), "b");
        thread1.start();
        thread2.start();
    }

}


