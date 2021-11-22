package com.javarush.task.pro.task02.task0202;

/* 
Полнометражная картина
*/

public class Solution {
    static int centimeters = 243;

    public static int calculateMeters(int cm){
        centimeters = cm;
        int meters = cm / 100; //напишите тут ваш код
        return meters;
    }

    public static void main(String[] args) {
        System.out.println(calculateMeters(centimeters));
    }
}