package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) {
        String fileName = null;

        try (BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = nameReader.readLine();
            //fileName = "c:\\java\\test.txt";
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileLine;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {

                while ((fileLine = fileReader.readLine()) != null) {
                    for (Map.Entry<Integer, String> entry : map.entrySet()) {
                        fileLine = fileLine.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                    }
                    System.out.println(fileLine);
                }
//                String[] splitted = fileReader.readLine().split(" ");
//
//                for (int i = 0; i < splitted.length; i++) {
//                   if (splitted[i].matches("\\b\\d*\\b")) {
//
//                        int d = Integer.parseInt(splitted[i]);
//                        //System.out.println(d);
//                        if (map.keySet().contains(d)){
//                            //System.out.println(map.get(d));
//                            splitted[i] = map.get(d);
//                        }
//                   }
//                   System.out.print(splitted[i] + " ");
//                    }
//                    //System.out.println("\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
