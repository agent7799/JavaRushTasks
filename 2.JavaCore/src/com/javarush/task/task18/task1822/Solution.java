package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {


        try {
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();
            //String fileName = "c:\\java\\test.txt";

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String info;

            while (reader.ready()) {
                info = reader.readLine();
                if (info.contains(args[0]+ " ")) {
                    System.out.println(info);
                }
            }

            scanner.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
