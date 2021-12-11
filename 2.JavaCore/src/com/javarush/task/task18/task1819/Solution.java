package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        try {
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = nameReader.readLine();
        String secondFile = nameReader.readLine();
          //  String firstFile = "c:\\java\\test1.txt";
          //  String secondFile = "c:\\java\\test2.txt";

        nameReader.close();



        FileInputStream inputStreamOne = new FileInputStream(firstFile);
        FileInputStream inputStreamTwo = new FileInputStream(secondFile);
        FileOutputStream outputStream = new FileOutputStream(firstFile);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            while (inputStreamTwo.available() > 0){
                byteArrayOutputStream.write(inputStreamTwo.read());
            }
            while (inputStreamOne.available() > 0){
                byteArrayOutputStream.write(inputStreamOne.read());
            }

            byteArrayOutputStream.writeTo(outputStream);

            inputStreamOne.close();
            inputStreamTwo.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
