package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
//            String firstFileName = "c:\\java\\test.txt";
//            String secondFileName = "c:\\java\\test1.txt";

            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(firstFileName));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFileName));

            //String regex  = "\\b\\d{1,}\\b";

            while (fileReader.ready()) {
                for (String str : fileReader.readLine().split(" ")){
                    if (str.matches("\\b\\d{1,}\\b")){
                        fileWriter.write(str + " ");
                        System.out.println(str);
                    }
                }
            }

            fileReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
