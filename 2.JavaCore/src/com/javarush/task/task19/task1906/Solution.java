package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {


    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        try {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
            reader.close();

            FileReader fileReader = new FileReader(firstFileName);
            FileWriter fileWriter = new FileWriter(secondFileName);
            int index = 1;
            while (fileReader.ready()) {
                int c = fileReader.read();
                if (index % 2 == 0) {
                    fileWriter.write(c);
                }
                index++;
            }
            fileReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
