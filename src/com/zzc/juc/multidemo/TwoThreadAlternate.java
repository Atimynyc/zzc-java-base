package com.zzc.juc.multidemo;

import java.sql.SQLOutput;

/**
 * @Description: 双线程交替
 * @Version: 1.0
 * @Author: Zheng Zhenchao
 * @Create Date: 2021/10/26
 * @Copyright: SwiftPass Technologies Co., LTD. Rights Reserved
 */
public class TwoThreadAlternate {

    private static int count = 0;
    // 设定锁对象
    private final static Object lock = new Object();

    static class TurningRunner implements Runnable {
        @Override
        public void run() {

            while (count <= 10) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notifyAll();

                    // 如果任务还没有结束，则让出当前的锁并休眠
                    try {
                        if (count <= 10) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new TurningRunner());
        Thread threadB = new Thread(new TurningRunner());
        threadA.start();
        threadB.start();
    }

}
