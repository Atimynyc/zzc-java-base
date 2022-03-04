package com.zzc.juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        new Thread (
                () -> {
                    try {
                        while(true) {
                            System.out.println(" 拿东西" +queue.take());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();

        new Thread (
                () -> {
                    try {
                        System.out.println("thread2 开始放东西 1");
                        queue.put(1);
                        /*System.out.println("thread2 开始放东西 2");
                        queue.put(1);
                        System.out.println("thread2 开始放东西 3");
                        queue.put(1);*/
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();


    }

}
