package com.javarush.task.task18.task1826;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {

        try {
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            byte key = -1;

            String fileName = args[1];
            String fileOutputName = args[2];

            FileInputStream fileInputStream = new FileInputStream(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);

            //byte[] buffer = new byte[fileInputStream.available()];
            List<Integer> list = new ArrayList<>();

            while (fileInputStream.available() >0){
                list.add(fileInputStream.read());
            }

            if (args[0].equals("-e")){
                for (Integer i : list){
                    i = i + key;
                    fileOutputStream.write(i);
                }

            }else if (args[0].equals("-d")){
                for (Integer i : list){
                    i = i - key;
                    fileOutputStream.write(i);
                }
            }

            fileInputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
