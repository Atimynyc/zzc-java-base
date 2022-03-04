package com.zzc.juc.multidemo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 循环打印ABC
 * @Version: 1.0
 * @Author: Zheng Zhenchao
 * @Create Date: 2021/10/26
 * @Copyright: SwiftPass Technologies Co., LTD. Rights Reserved
 */
public class CirclePrintABC {
    public ReentrantLock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private volatile int status = 0;

    public static void main(String[] args) {
        System.out.println("开始");
        new CirclePrintABC().printABC();
    }


    private void printABC() {
        new Thread(() -> {
            this.print("A", 0, 1, conditionA, conditionB);
        }).start();

        new Thread(() -> {
            this.print("B", 1, 2, conditionB, conditionC);
        }).start();

        new Thread(() -> {
            this.print("C", 2, 0, conditionC, conditionA);

        }).start();
    }

    public void print(String s, int flg, int nextStatus, Condition currentCondition, Condition nextCondition) {
        for (int i = 0; i < 10; i++) {
            try {
                lock.lock();
                while(flg != status) {
                    currentCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + " " +s);
                status = nextStatus;
                nextCondition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }



}
