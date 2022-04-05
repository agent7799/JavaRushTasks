package com.javarush.task.task20.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код

        parametersOut(url);
    }





    private static void parametersOut(String url) {
       // System.out.println("url string: " + url + "\n");

        String temp;
        temp = url.substring(url.indexOf("?")+1);

        ArrayList<String> stringList = new ArrayList<>();
        String[] strings = temp.split("&");

        for (String s : strings){
            //System.out.println(s);
            if (s.contains("=")){
                s = s.substring(0, s.indexOf('='));
            }
            stringList.add(s);
            System.out.print(s + " ");
        }
        System.out.println("");

        String obj = "obj=";
        String result;
        if (url.contains(obj)) {
            result = (url.substring(url.indexOf(obj) + obj.length(), url.indexOf("&")));
            if (isDouble(result)) {
                alert(Double.parseDouble(result));
            } else {
                alert(result);
            }
        }


    }

    public static boolean isDouble(String string) {
        Pattern doublePattern = Pattern.compile("-?\\d+(\\.\\d*)?");
        return doublePattern.matcher(string).matches();
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {

        System.out.println("String: " + value);
    }
}
