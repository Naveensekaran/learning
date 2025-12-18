package com.springboot.learning.core;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MyCheckedExcetion extends Exception{
    MyCheckedExcetion(String message){
        super(message);
    }
}

class MyUnCheckedException extends RuntimeException{
    MyUnCheckedException(String message){
        super(message);
    }
}

public class ExceptionHandling {
    int a =0;
    int[] num = {1,2,3};

    String naveen = null;


    public void checkedException() throws FileNotFoundException, SQLException, ClassNotFoundException, InterruptedException, MyCheckedExcetion {
        FileReader file = new FileReader("pom.xml");

        FileInputStream fileInputStream = new FileInputStream("naveen.txt");

        Connection con = DriverManager.getConnection("jdbc:postgres://localhost/learning", "postgres","postgres");

        Class.forName("com.springboot.learning.core");

        Thread.sleep(10);

        throw new MyCheckedExcetion("User not found");
    }

       public void unCheckedException(){
        try {
            System.out.println("Naveenkumar");
//            return;
            a = a/0;
            int a = num[5];
            naveen.toUpperCase();

            throw new MyUnCheckedException("Age must be above 18");
        }
        catch (ArithmeticException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Naveen");
        }


    }

    public void tryWithResource() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            System.out.println(br.readLine());
        }
    }

    public static void main(String[] args){
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        exceptionHandling.unCheckedException();

    }
}
