package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName = reader.readLine();

            FileInputStream fileInputStream = new FileInputStream(fileName);

            int n = 0;
            while (fileInputStream.available() > 0){
                if (fileInputStream.read() == 44){
                    n++;
                }
            }
            System.out.println(n);
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
