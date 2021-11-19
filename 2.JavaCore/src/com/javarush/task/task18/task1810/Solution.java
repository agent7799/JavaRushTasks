package com.javarush.task.task18.task1810;

import java.io.*;


/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

            int n;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream;
            while (true) {
                fileInputStream = new FileInputStream(reader.readLine());
                n = fileInputStream.available();
                if (n < 1000) {
                    reader.close();
                    fileInputStream.close();
                    throw new DownloadException();
                }
            }
    }

        public static class DownloadException extends Exception {
    }
}
