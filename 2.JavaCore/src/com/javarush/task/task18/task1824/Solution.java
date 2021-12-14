package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.Scanner;


/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String s = scanner.nextLine();

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
                reader.close();

            } catch (FileNotFoundException e) {
                System.out.println(s);

                break;
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }
}
