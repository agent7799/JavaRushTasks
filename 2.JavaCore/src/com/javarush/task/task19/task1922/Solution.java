package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        //String fileName = "c:\\java\\test.txt";
        try {
            fileName = console.readLine();
            console.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int counter = 0;

            while (reader.ready()) {
                line = reader.readLine();
                String[] lines = line.split(" ");
                for (String s : words) {
                    for (int i = 0; i < lines.length; i++) {
                        if (lines[i].equals(s)) {
                            counter++;
                        }
                    }
                }
                if (counter == 2) {
                    System.out.println(line);
                }
                counter = 0;

            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
