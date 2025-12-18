package com.springboot.learning.core;


class Parent1{
    public int sum(int a, int b){
        return a+b;
    }

    public int sum(int a, int b, int c){
        return a+b+c;
    }
}

class Child1 extends Parent1{
    public int sum(int a, int b){
        return a*b;
    }
}

public class Polymorphism {
    public static void main(String[] args){
        Child1 parent1 = new Child1();
        System.out.println(parent1.sum(1,1));
        System.out.println(parent1.sum(1,1,1));
    }
}
