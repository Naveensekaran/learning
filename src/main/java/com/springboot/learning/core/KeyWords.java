package com.springboot.learning.core;

class Super{
    int a = 30;
    int b = 40;

    Super(){
        System.out.println(a+b);
    }

    public void setA(int a){
        this.a = a;
    }

    public void setB(int b){
        this.b = b;
    }

    public static void staticMethod(){
        System.out.println("Static method executed");
    }
}

public class KeyWords extends Super {

    public volatile boolean running = true;

    KeyWords(){
        super();
        System.out.println(super.a);
    }

    public void startRunning(){
        System.out.println("started running");
        while(running){
        }
        System.out.println("Ended running");

    }

    public void stopRunning(){
        System.out.println("Stop was called");
         running = false;
    }

    public static void main(String args[]) throws InterruptedException {
        final int a=10;
        final int b=10;
        KeyWords keyWords = new KeyWords();
        Thread t1  = new Thread(()->keyWords.startRunning());
        t1.start();

        Thread.sleep(2000);

        keyWords.stopRunning();
    }
}
