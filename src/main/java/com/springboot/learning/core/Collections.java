package com.springboot.learning.core;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Collections {

        public static void main(String[] args){
                List list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(1);

                list = new LinkedList();

//                list.forEach(System.out::println);

                LinkedList<Integer> linkedList = new LinkedList();
                linkedList.add(null);
                linkedList.add(2);
                linkedList.add(3);

//                linkedList.forEach(System.out::println);

                CopyOnWriteArrayList<String> vector = new CopyOnWriteArrayList<>();
                vector.add("naveen");
                vector.add("kumar");
                vector.add("naveen");

//                vector.forEach(System.out::println);

                Queue<String> pq = new PriorityQueue<>();


                pq.add("agu");
                pq.add(null);


//                pq.remove();
//                pq.poll();

//                pq.element();
//                pq.peek();
                pq.forEach(System.out::println);

        }
}
