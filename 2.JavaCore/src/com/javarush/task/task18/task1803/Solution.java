package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int[] byteCountArray = new int[256];
        Map<Integer, Integer> map = new HashMap<>();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "c:\\java\\test.txt";

        FileInputStream fileInputStream = new FileInputStream(fileName);
        //FileInputStream fileInputStream = new FileInputStream("c:\\java\\test.txt");

        while (fileInputStream.available() > 0) {
            byteCountArray[fileInputStream.read()] += 1;
        }
        reader.close();
        fileInputStream.close();



        int max = 0;
        for (int b : byteCountArray) {
           // map.put(b, Collections.frequency(bytes, b));
            max = max < b ? b : max;
           //System.out.print(b + " ");
        }
//        System.out.println("");
//        System.out.println(max);

        for (int i = 0; i < byteCountArray.length; i++) {
            if (byteCountArray[i] == max){
                System.out.print(i + " ");
            }

        }

    }
}
