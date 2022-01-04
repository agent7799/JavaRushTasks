package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();

            FileInputStream fileInputStream = new FileInputStream(fileName1);
            FileOutputStream fileOutputStream = new FileOutputStream(fileName2);


            byte[] buffer = new byte[fileInputStream.available()];
            List<Integer> list = new ArrayList<>();


            while (fileInputStream.available() >0){
                list.add(fileInputStream.read());
            }

            Collections.reverse(list);
            for (Integer i : list){
                fileOutputStream.write(i);
            }

            fileInputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
