package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    static Scanner scanner = new Scanner(System.in);




    public Solution() throws FileNotFoundException {
    }


    public static void main(String[] args) throws CorruptedDataException, FileNotFoundException {

        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));


        try {

            while (reader1.ready()) {
                allLines.add(reader1.readLine());
            }

            while (reader2.ready()) {
                forRemoveLines.add(reader2.readLine());
            }
            reader1.close();
            reader2.close();

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Solution().joinData();   // method joinData to be called on some Object -  "new Solution()"

    }

    public void joinData() throws CorruptedDataException {

            if (allLines.containsAll(forRemoveLines)) {
                allLines.removeAll(forRemoveLines);
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
    }

}
