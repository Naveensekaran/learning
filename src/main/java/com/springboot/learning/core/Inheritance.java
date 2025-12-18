package com.springboot.learning.core;

class Parent{
    public String behavior(){
        return "Providing";
    }
}

class Child extends Parent{

    public String behavior(){
        return "Accessing";
    }

    public String behavior1(){
        return "Accessing1";
    }
}

public class Inheritance {
    public static void main(String[] args){
        Parent parent = new Child();
        System.out.println(parent.behavior());
    }
}


