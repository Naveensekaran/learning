package com.springboot.learning.core;

interface Animal{
    public void behavior();
}

class Dog implements Animal{
    public void behavior(){
        System.out.println("Bark");
    }
}

class Cat implements Animal{

    public void behavior(){
        System.out.println("Meeooww");
    }
}

public class FunctionalInterface {
    public static void main(String[] args){
      Animal animal = new Animal() {
          public void behavior() {
              System.out.println("Run");
          }
      };

      Animal animal1 = ()-> System.out.println("Naveen");

      animal.behavior();
      animal1.behavior();


    }
}
