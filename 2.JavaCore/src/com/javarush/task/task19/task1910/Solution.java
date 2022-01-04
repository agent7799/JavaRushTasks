package com.javarush.task.task19.task1910;

import java.io.*;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
//            String firstFileName = reader.readLine();
//            String secondFileName = reader.readLine();
            String firstFileName = "c:\\java\\test.txt";
            String secondFileName = "c:\\java\\test1.txt";

            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(firstFileName));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFileName));

            StringBuilder text = new StringBuilder();

            String str;
            while (fileReader.ready()) {
                str = fileReader.readLine().replaceAll("\\p{Punct}", "").replaceAll("\n","");
                fileWriter.write(str);
            }

            fileReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
