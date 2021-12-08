package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {

        try {
            double countSymbols = 0;
            double countSpaces = 0;

            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            while (reader.ready()){

                if ((char) reader.read() == ' '){
                    countSpaces++;
                }
                countSymbols++;

            }
//            System.out.println("Spaces - " + countSpaces );
//            System.out.println("Symbols - " + countSymbols);
//            System.out.println(countSpaces/countSymbols);
            System.out.printf("%.2f", countSpaces/countSymbols*100);
            reader.close();





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
