package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
            String thirdFileName = reader.readLine();
            reader.close();

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(firstFileName));
        //BufferedWriter fileWriterAppend = new BufferedWriter(new FileWriter(firstFileName, true));
        BufferedReader secondFileReader = new BufferedReader(new FileReader(secondFileName));
        BufferedReader thirdFileReader = new BufferedReader(new FileReader(thirdFileName));


        while (secondFileReader.ready()){
            fileWriter.write(secondFileReader.read());
        }
            //fileWriter.close();
            secondFileReader.close();

            while (thirdFileReader.ready()){
                fileWriter.write(thirdFileReader.read());
            }
            thirdFileReader.close();
            //fileWriterAppend.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
