package com.zzc.juc.tools;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import javafx.concurrent.Worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchLearn {

    public static void main(String[] args) throws Exception{
        int n = 5;
        CountDownLatch startSignal = new CountDownLatch(1);

        CountDownLatch doneSignal = new CountDownLatch(n);
        // create and start threads
        for (int i = 0; i < n; ++i) {
            new Thread(new Worker1(startSignal, doneSignal)).start();
        }
        Map<String, String> map = new HashMap<>();
        System.out.println("start");
        startSignal.countDown();
        System.out.println("end");
        doneSignal.await();



    }

}

class Worker1 implements Runnable {
   private final CountDownLatch startSignal;
   private final CountDownLatch doneSignal;
    Worker1(CountDownLatch startSignal, CountDownLatch doneSignal) {
     this.startSignal = startSignal;
     this.doneSignal = doneSignal;
   }
   public void run() {
     try {
       startSignal.await();
       doWork();
       doneSignal.countDown();
     } catch (InterruptedException ex) {} // return;
   }

   void doWork() {
       System.out.println("doing work");
   }
}
