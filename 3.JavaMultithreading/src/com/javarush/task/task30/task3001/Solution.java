package com.javarush.task.task30.task3001;

/*
Конвертер систем счислений
*/

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "1234af");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        //напишите тут ваш код
        StringBuilder stringBuilder = new StringBuilder();
        int numberSystem = number.getNumberSystem().getNumberSystemIntValue();
        int m = expectedNumberSystem.getNumberSystemIntValue();
        String numberString = number.getDigit();

        String digits = "0123456789abcdef";

        System.out.println();
        System.out.println(numberString);
        System.out.println("source number base " + numberSystem);
        System.out.println("target number base " + m);

        for (int i = 0; i < numberString.length(); i++) {
            char c = numberString.toLowerCase().charAt(i);
            if (digits.indexOf(c) > numberSystem - 1) {
                System.out.println(digits.indexOf(c) + " > " + (numberSystem-1));
                throw new NumberFormatException();
            }
        }

        BigInteger A = new BigInteger(numberString.toUpperCase(), numberSystem);
        BigInteger M = new BigInteger(m + "");

        while (true) {
            BigInteger divider = A.divide(M);
            BigInteger reminder = A.remainder(M);

            if (reminder.compareTo(BigInteger.ZERO) > 0) {        //
                System.out.println("делим " + A + "  на " + M + " = " + divider + " остаток " + reminder);
                stringBuilder.append(digits.charAt(reminder.intValue()));
                A = divider;
            } else {
                stringBuilder.append(digits.charAt(A.intValue()));
                break;
            }
        }

//        CONVERTER

//        while (true) {
//            if (a / m > 0) {
//                System.out.println("делим " + a + "  на " + m + " = " + a / m + " остаток " + a % m);
//                stringBuilder.append(digits.charAt(a % m));
//                a = a/m;
//            } else {
//                stringBuilder.append(digits.charAt(a));
//                break;
//            }
//        }


        stringBuilder.reverse();
        return new Number(expectedNumberSystem, stringBuilder.toString());

    }

//    public static int hexToDecimal(String s) {
//        String digits = "0123456789ABCDEF";
//        s = s.toUpperCase();
//        int val = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            int d = digits.indexOf(c);
//            val = 16 * val + d;
//        }
//        return val;
//    }
}
