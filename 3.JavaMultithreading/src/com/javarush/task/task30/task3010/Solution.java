package com.javarush.task.task30.task3010;

/*
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String test = "00";
        String test1 = "12AS08z";
        String test2 = "12AS08Z/";
        // String test3 = args[0];

        System.out.println(isStringCorrect(test));
        System.out.println(isStringCorrect(test1));
        System.out.println(isStringCorrect(test2));

        //findMinRadix(args[0]);
        System.out.println(findMinRadix(test));
        System.out.println(findMinRadix(test1));
        System.out.println(findMinRadix(test2));
    }

    private static boolean isStringCorrect(String s) {
        if (s.length() > 255) {
            return false;
        } else if (s.matches("\\W")) {
            System.out.println("not matches");
            return false;
        } else {

            for (int a : s.toCharArray()) {
                if (a < 32 || a > 127) {
                    return false;
                }
            }
        }
        return true;
    }


    private static String findMinRadix(String number) {
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if (!isStringCorrect(number)) {
            System.out.println("incorrect");
            return "incorrect";
        }

        int minRadix = digits.indexOf(number.toUpperCase().charAt(0));
        for (int i = 0; i < number.length(); i++) {
            char ch = number.toUpperCase().charAt(i);
            minRadix = digits.indexOf(ch);
            if (digits.contains(number.substring(i, i + 1))) {
                if (minRadix > ch) {
                    minRadix = i;
                }
            }
        }
        return minRadix + "";
    }


}