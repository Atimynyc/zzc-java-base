package com.zzc.juc.multidemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 三线程循环打印
 * @Version: 1.0
 * @Author: Zheng Zhenchao
 * @Create Date: 2021/10/26
 * @Copyright: SwiftPass Technologies Co., LTD. Rights Reserved
 */
public class ThreeThreadAlternate extends Thread{
    /**
     * 多个线程共享这一个sequence数据
     */
    private static int sequence = 1;
    private static final int SEQUENCE_END =75;

    private int id;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition[] conditions = {lock.newCondition(),lock.newCondition(),lock.newCondition()};

    private ThreeThreadAlternate(int id) {
        this.id = id;
        this.setName("线程：" + (id + 1));
    }

    @Override
    public void run() {
        while (sequence < SEQUENCE_END) {
            lock.lock();
            try {
                //对序号取模,如果不等于当前线程的id,则先唤醒其他线程,然后当前线程进入等待状态
                while ((sequence/5) % conditions.length != id) {
                    conditions[(id + 1) % conditions.length].signal();
                    conditions[id].await();
                }
                for(int i = 0; i < 5; i++)
                {
                    System.out.println(Thread.currentThread().getName() + " " + sequence++);
                }
                //唤醒当前线程的下一个线程
                conditions[(id + 1) % conditions.length].signal();
                //当前线程进入等待状态
                conditions[id].await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //将释放锁的操作放到finally代码块中,保证锁一定会释放
                lock.unlock();
            }
        }
        //数字打印完毕,线程结束前唤醒其余的线程,让其他线程也可以结束
        end();
    }

    private void end() {
        lock.lock();
        conditions[(id + 1) % conditions.length].signal();
        conditions[(id + 2) % conditions.length].signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        int threadCount = 3;
//        ReentrantLock lock = new ReentrantLock();
//        Condition[] conditions = new Condition[threadCount];
//        for (int i = 0; i < threadCount; i++) {
//            conditions[i] = lock.newCondition();
//        }
        ThreeThreadAlternate[] printNumbers = new ThreeThreadAlternate[threadCount];
        for (int i = 0; i < threadCount; i++) {
            printNumbers[i] = new ThreeThreadAlternate(i);
        }
        for (ThreeThreadAlternate printNumber : printNumbers) {
            printNumber.start();
        }
    }

}
