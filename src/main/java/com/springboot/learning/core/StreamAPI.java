package com.springboot.learning.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

//       list = list.stream().map(e-> e+1).collect(Collectors.toList());

//        list.parallelStream().map(e-> e+1).collect(Collectors.toList());

        int sum = list.stream().reduce(0, (a,b) -> a+b);
        System.out.println(sum);
//        list.forEach(System.out::println);
    }
}
