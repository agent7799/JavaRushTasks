package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
            String firstFile = nameReader.readLine();
            String secondFile = nameReader.readLine();
            // String firstFile = "c:\\java\\test1.txt";
            // String secondFile = "c:\\java\\test2.txt";
            nameReader.close();

            FileInputStream inputStream = new FileInputStream(firstFile);
            FileOutputStream outputStream = new FileOutputStream(secondFile);

            ArrayList<String> arr = new ArrayList<>();

            Scanner s = new Scanner(inputStream).useDelimiter(" ");

            while (s.hasNext()) {
                arr.add(Math.round(Double.parseDouble(s.next())) + " ");
            }

            for (String i : arr) {
                outputStream.write(i.getBytes());
            }

            s.close();
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
