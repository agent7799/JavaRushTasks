package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        fileName = "c:\\java\\test2.txt";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        String line;
        //StringBuilder builder = new StringBuilder();
        do {
            line = bufferedReader.readLine();
            //builder.append(line).append("\n");
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } while (!line.equalsIgnoreCase("exit"));




        bufferedWriter.close();
    }
}
