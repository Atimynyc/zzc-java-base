package com.zzc.juc.threadlocal;

public class ThreadLocalTest {

    private static final ThreadLocal<String> LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<String> LOCAL2 = new ThreadLocal<>();

    public static void main(String[] args) throws Exception{
        Thread t = Thread.currentThread();
        LOCAL.set("doge");
        LOCAL2.set("cat");
        System.out.println(LOCAL.get());



        LOCAL.remove();
    }

}
