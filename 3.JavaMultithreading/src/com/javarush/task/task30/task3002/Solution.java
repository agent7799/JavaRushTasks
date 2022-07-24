package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код

        Integer integer;

        if (s.substring(0, 2).equalsIgnoreCase("0x")){
            integer = Integer.parseInt(s.substring(2), 16);
        }else if (s.substring(0, 2).equalsIgnoreCase("0b")){
            integer = Integer.parseInt(s.substring(2), 2);
        }else if (s.substring(0, 1).equalsIgnoreCase("0")){
            integer = Integer.parseInt(s.substring(1), 8);
        }else {
            integer = Integer.parseInt(s, 10);
        }

        return integer.toString();
    }
}
