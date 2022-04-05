package com.javarush.task.task20.task15.task1517;

/* 
Статики и исключения
*/

public class Solution {
    public static int A = 0;

    static {
       try{ //throw an exception here - выбросьте эксепшн тут
        throw new ExceptionInInitializerError();

       } catch (RuntimeException e) {
           e.printStackTrace();
       }
    }

    public static int B = 5;

    public static void main(String[] args) {

        System.out.println(B);
    }
}
