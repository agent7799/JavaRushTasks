package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код


        Scanner scanner = new Scanner(System.in);

        String fileName = "c:\\java\\test2.txt";

       //String fileName = scanner.nextLine();                                       // получаем имя файла с консоли

        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                                                                                    // поток чтения из файла
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (bufferedReader.ready()) {
            int a = Integer.parseInt(bufferedReader.readLine());                 // пишем в массив строки, распарсенные в Integer
            arrayList.add(a);
        }
        arrayList.sort(Comparator.naturalOrder());                              // сортировка

        for (int a : arrayList){
            if (a%2 == 0){
                System.out.println(a);                                              // вывод только четных
            }
        }

        scanner.close();
        bufferedReader.close();
        fileInputStream.close();
    }
}
