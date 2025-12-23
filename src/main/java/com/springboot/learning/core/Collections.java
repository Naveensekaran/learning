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

//                System.out.println(linkedList.get(0));
//                linkedList.forEach(System.out::println);

                CopyOnWriteArrayList<String> vector = new CopyOnWriteArrayList<>();
                vector.add("naveen");
                vector.add("kumar");
                vector.add("naveen");

//                vector.forEach(System.out::println);

                Queue<String> pq = new PriorityQueue<>();


//                pq.add("agu");
//                pq.add(null);


//                pq.remove();
//                pq.poll();

//                pq.element();
//                pq.peek();
//                pq.forEach(System.out::println);

                Set<String> hashSet = new HashSet<>();
                hashSet.add("Naveen");
                hashSet.add("agu");
                hashSet.add(null);
                hashSet.add(null);

//                System.out.println(hashSet.size());

//                hashSet.forEach(System.out::println);


                Set<Integer> linkedHashSet = new TreeSet<>();
                linkedHashSet.add(1);
                linkedHashSet.add(3);
                linkedHashSet.add(2);
//                linkedHashSet.add(null);
//                linkedHashSet.forEach(System.out::println);

                Map<Integer, String> hashMap = new HashMap<>();
                hashMap.put(1,"naveen");
                hashMap.put(2,"kumar");

                for(String ma : hashMap.values()){
                        System.out.println(ma);
                }

                hashMap.forEach((integer, s) -> System.out.println());

        }
}
