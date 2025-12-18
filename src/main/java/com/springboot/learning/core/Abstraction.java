package com.springboot.learning.core;


abstract class Vehicle{
    abstract String car();
    abstract String bike();
    public String bicycle(){
        return "Driving bicycle";
    }
}

interface lorry{
      String bikee();
}

class Drive extends Vehicle{
    public String car(){
        return "Driving Car";
    }

    public String bike(){
        return "Driving Bike";
    }

    public String bus(){
        return "Driving Bus";
    }

    public String bicycle(){
        return "Driving cycle";
    }

}

public class Abstraction {

    public static void main(String[] args){
        Vehicle drive = new Drive();
        System.out.println(drive.bike());
        System.out.println(drive.car());
        System.out.println(drive.bicycle());
    }
}
