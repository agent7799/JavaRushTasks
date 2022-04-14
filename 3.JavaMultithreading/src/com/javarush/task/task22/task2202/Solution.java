package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(":" + getPartOfString("JavaRush- лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] splitWithSpaces = string.split(" ");

        if (splitWithSpaces.length < 5) throw new TooShortStringException();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < 5; i++) {
            stringBuilder.append(splitWithSpaces[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

//    public static String getPartOfString(String string) {
//        int spaceCounter = 0;
//        int indexOfFourthSpace = 0;
//        if (string == null) {
//            throw new TooShortStringException();
//        }
//        try {
//            for (int i = 0; i < string.length(); i++) {
//                if (string.charAt(i) == ' ') {
//                    spaceCounter++;
//                }
//                if (spaceCounter == 4) {
//                    indexOfFourthSpace = i;
//                }
//            }
//            System.out.println(spaceCounter);
//            if (spaceCounter < 4){
//                throw new TooShortStringException();
//            }
//        } catch (Exception e) {
//            System.out.println("EXCEPTION: мало пробелов");
//            //e.printStackTrace();
//        }
//        return string.substring(string.indexOf(" ") + 1, indexOfFourthSpace + 1);
//    }


    public static class TooShortStringException extends RuntimeException {

    }

}
