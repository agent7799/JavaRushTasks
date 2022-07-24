package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number){
        Set<Integer> numericSystems = new HashSet<>();

        for (int i = 2; i < 36 + 1; i++) {
            try {
                String numberInRadix = Integer.toString(Integer.parseInt(number), i);
                if(isPalindrome(numberInRadix)){
                    //System.out.println("number " + number + " is " + numberInRadix + " is palindrome for radix " + i );
                    numericSystems.add(i);
                }
                //System.out.println(number + " = " + numberInRadix + " in radix" + i);

            } catch (NumberFormatException ignored) {
                //System.out.println("exception: " + number + " in radix: " + i);
            }
        }
        return numericSystems;
    }

    private static boolean isPalindrome(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private static boolean isNumberCorrect(String number, int numericSystemBase){
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < number.length(); i++) {
            char ch = number.toUpperCase().charAt(i);
            if (ch > digits.indexOf(ch)-1){
                return false;
            }
        }
        return true;
    }

}