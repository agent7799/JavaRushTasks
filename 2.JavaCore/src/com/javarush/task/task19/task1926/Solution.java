package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            //String fileName = "c:\\java\\test.txt";
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            String fileLine;
            while ((fileLine = fileReader.readLine()) != null){
                System.out.println(new StringBuilder(fileLine).reverse().toString());
            }

            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
