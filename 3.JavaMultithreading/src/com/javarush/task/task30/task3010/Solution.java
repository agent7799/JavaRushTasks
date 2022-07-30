package com.javarush.task.task30.task3010;

/*
Минимальное допустимое основание системы счисления

//           00 expected 2
//           12AS08z expected 36
//           12AS08Z/ expected incorrect

*/

import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            // findMinRadix(args[0]);    //my solution
            findSolution(args[0]);      //solution from JR

//            findMinRadix("00");
//            findSolution("00");
//
//            findMinRadix("12AS08z");
//            findSolution("12AS08z");
//
//            findMinRadix("12AS08Z/");
//            findSolution("12AS08Z/");
        } catch (Exception e) {
        }
    }

    private static void findMinRadix(String number) {
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String regex = "[^0-9a-zA-Z]";

        String line = number;
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(line).find()) {
            System.out.println("incorrect");
        } else {
            int minRadix = digits.indexOf(number.toUpperCase().charAt(0));
            for (int i = 0; i < number.length(); i++) {
                int ch = number.toUpperCase().charAt(i);
                minRadix = digits.indexOf(ch) + 1;
                if (digits.contains(ch + "")) {
                    if (minRadix > digits.indexOf(ch) + 1) {
                        minRadix = digits.indexOf(ch) + 1;
                    }
                }
            }
            minRadix = minRadix < 2 ? 2 : minRadix;
            System.out.println(minRadix);
        }
    }

    private static void findSolution(String line) {
        Pattern pattern = Pattern.compile("[^0-9A-Za-z]");
        if (pattern.matcher(line).find()) {
            System.out.println("incorrect");
        } else {
            char max = 0;
            char[] chars = line.toUpperCase().toCharArray();
            for (char current : chars) {
                if (current > max) {
                    max = current;
                }
            }
            int radix;
            if (max <= '9') {
                radix = max - 47;
            } else {
                radix = max - 54;
            }
            if (radix < 2) {
                radix = 2;
            }
            System.out.println(radix);
        }
    }
}