package com.springboot.learning.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadIExtends extends Thread{
    public void run(){
        System.out.println("Thread print");
    }
}

class ThreadImplements implements Runnable{
    public synchronized void run(){
        System.out.println("Thread Entered");
        try {
            wait();
//            Thread.sleep(2000);
            System.out.println("Runnable print");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread Exiting");
    }
}
public class Threads {

    public static void main(String args[]) throws InterruptedException {
        ThreadIExtends threadIExtends = new ThreadIExtends();
//        threadIExtends.start();

        ThreadImplements threadImplements = new ThreadImplements();
        Thread t1 = new Thread(threadImplements);
        Thread t2 = new Thread(threadImplements);

        t1.start();
        t2.start();

        t1.join();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(()->{
            System.out.println("Thread name "+ Thread.currentThread().getName());
        });
    }

}
