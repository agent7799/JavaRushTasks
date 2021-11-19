package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            String fileName3 = reader.readLine();

            FileInputStream fileInputStream = new FileInputStream(fileName1);
            FileOutputStream fileOutputStream1 = new FileOutputStream(fileName2);
            FileOutputStream fileOutputStream2 = new FileOutputStream(fileName3);



            int n = fileInputStream.available();
            byte[] buffer = new byte[n];
            fileInputStream.read(buffer);
            if (n%2 == 0){
                fileOutputStream1.write(buffer, 0, n/2);
                fileOutputStream2.write(buffer, n/2, n/2);
            } else {
                fileOutputStream1.write(buffer, 0, n/2+1);
                fileOutputStream2.write(buffer, n/2+1, n/2);
            }


            fileInputStream.close();
            fileOutputStream1.close();
            fileOutputStream2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
