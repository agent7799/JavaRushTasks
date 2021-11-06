package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       //int n1 = inputPositiveInt();
       // int n2 = inputPositiveInt();
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        System.out.println(getNOD(a, b));

    }
    public static int getNOD(int a, int b) {
        //int ost = max % min;
        while (a != b) {
            if (a > b){
                a = a - b;
            }else if (b > a){
                b = b - a;
            }
            //System.out.println(" max " + max + " min " + min + " ost " + ost);
        }
        return a;

    }

//    public static void getNOD(int n1, int n2) {
//        int max = Math.max(n1, n2);
//        int min = Math.min(n1, n2);
//        int ost = max % min;
//        while (ost != 0) {
//            ost = max % min;
//            max = Math.max(ost, min);
//            min = Math.min(ost, min);
//            ost = max % min;
//            System.out.println(" max " + max + " min " + min + " ost " + ost);
//        }
//        System.out.println("НОД: " + min);
//    }

//    public static int inputPositiveInt(){
//        int i =0;
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            int n = 0;
//            while (n < 1) {
//                System.out.println("Enter positive integer number:");
//                String s1 = reader.readLine();
//                i = Integer.parseInt(s1);
//                if (i <= 0) {
//                    System.out.println("Value is less 0, enter positive integer number: ");
//                    continue;
//                }
//                n++;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Entered: " +i);
//        return i;
//    }


}
