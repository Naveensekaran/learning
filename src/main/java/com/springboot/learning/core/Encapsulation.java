package com.springboot.learning.core;

public class Encapsulation {
    private int a;
    private int b;

    public void setA(int a){
        this.a = a;
    }

    public void setB(int b){
        this.b = b;
    }

    public int getA(){
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public static void main(String[] args){
       Encapsulation encapsulation = new Encapsulation();
       encapsulation.setA(10);
       System.out.println("A is " +encapsulation.getA());
       encapsulation.setB(20);
       System.out.println("B is "+encapsulation.getB());

    }
}


