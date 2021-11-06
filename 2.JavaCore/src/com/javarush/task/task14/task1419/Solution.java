package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        int i = 0;
        for (Exception exception : exceptions) {

            System.out.println(exception +" " + i++);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0; //ArithmeticException #1

        } catch (Exception e) {
            exceptions.add(e);

        }

        try{
            String s = null;
            s.length();
           //throw new NullPointerException(); //#2
        }catch (Exception e) {
            exceptions.add(e);

        }


        //напишите тут ваш код
        try{
            //throw new FileNotFoundException(); //#3
            FileInputStream file = new FileInputStream("c:\\very_bad_broken_file.txt");
        }catch (Exception e) {
            exceptions.add(e);

        }

        try{
            throw new ClassCastException(); //#4

        }catch (Exception e) {
            exceptions.add(e);

        }

        try{
           // throw new NumberFormatException(); //#5
            String s = "digital value";
            int i = Integer.parseInt(s);
        }catch (Exception e) {
            exceptions.add(e);

        }

        try{
            throw new SecurityException(); //#6
        }catch (Exception e) {
            exceptions.add(e);

        }

        try{
            throw new ClassNotFoundException(); //#7
        }catch (Exception e) {
            exceptions.add(e);

        }

        try{
            throw new IndexOutOfBoundsException(); //#8
        }catch (Exception e) {
            exceptions.add(e);

        }

        try{
            int[] arr = {1, 2, 3, 3};
            System.out.println(arr[-2]);
            //throw new ArrayIndexOutOfBoundsException(); //#9
        }catch (Exception e) {
            exceptions.add(e);

        }

        try{
            //throw new ArrayStoreException(); //#10
            Object x[] = new String[3];
            x[0] = new Integer(0);
        }catch (Exception e) {
            exceptions.add(e);

        }


    }
}
