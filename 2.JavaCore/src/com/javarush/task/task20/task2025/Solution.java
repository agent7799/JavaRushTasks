package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    private static long N;


    public static long calculateArmstrongNumbers(long s){
        long arm = 0;
        String str = String.valueOf(s);
        int numberLength = (str).length();
        for (int i = 0; i < numberLength; i++) {
            //System.out.println((str.charAt(i)));
            //System.out.println(Math.pow(Integer.parseInt(String.valueOf(str.charAt(i))), numberLength));
            arm = (long) (arm + (Math.pow(Long.parseLong(String.valueOf(str.charAt(i))), numberLength)));
        }

        //System.out.println("Сумма цифр числа " + str + " , возведенных в степень " + numberLength + " : " + arm);
        return arm;
    }

    public static long[] getNumbers(long N) {
        if (N <= 1) return new long[0];

        ArrayList<Long> arms = new ArrayList<>();
        for (long i = 0; i < N; i++) {
            if (i == calculateArmstrongNumbers(i) && calculateArmstrongNumbers(i) < Long.MAX_VALUE ) {
                arms.add(i);
                //System.out.println(i);
                //result[(int) i] = i;
            }
        }
            long[] result = new long[arms.size()];
            for (int i= 0; i < arms.size(); i++) {
                result[i] = arms.get(i);
            //System.out.println(i);
        }
        return result;
    }


    public static void main(String[] args) {



        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1_000_000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
