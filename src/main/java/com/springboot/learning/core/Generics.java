package com.springboot.learning.core;

import java.util.ArrayList;
import java.util.List;

class Box<T>{
    private T value;

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public static <T> void print(T message){
        System.out.println(message);
    }
}

class Calculator<T extends Number>{
    public double square(T digit){
        return digit.doubleValue() * digit.doubleValue();
    }

    public static void printList(List<? extends Number> list){
        for (Number e : list) {
            System.out.println(e);
        }
    }

    public static void printList1(List<? super Integer> list){
        for (Object e : list) {
            System.out.println(e);
        }
    }
}



public class Generics {
    public static void main(String args[]){
        Box<Integer> boxInteger = new Box();
        boxInteger.setValue(200);

        Box<String> boxString= new Box<>();
        boxString.setValue("Naveen");

        Calculator<Integer> calculateInterger=new Calculator();
        Calculator<Double> calculateDouble=new Calculator();

        calculateInterger.square(2);
        calculateDouble.square(2.0);

        Calculator.printList(List.of(1));
        Calculator.printList(List.of(1.0));


    }
}
