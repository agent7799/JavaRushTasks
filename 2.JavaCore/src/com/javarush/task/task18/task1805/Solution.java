package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Set<Integer> set = new TreeSet<>();

 /*     Intro to TreeSet

        Simply put, the TreeSet is a sorted collection that extends the AbstractSet class and implements the
        NavigableSet interface.

        Here's a quick summary of the most important aspects of this implementation:
        It stores unique elements
        It doesn't preserve the insertion order of the elements
        It sorts the elements in ascending order
        It's not thread-safe

        In this implementation, objects are sorted and stored in ascending order according to their natural order.
        The TreeSet uses a self-balancing binary search tree, more specifically a Red-Black tree.
*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "c:\\java\\test.txt";

        FileInputStream fileInputStream = new FileInputStream(fileName);
        //FileInputStream fileInputStream = new FileInputStream("c:\\java\\test.txt");

        while (fileInputStream.available() > 0) {
           set.add(fileInputStream.read());

        }
        reader.close();
        fileInputStream.close();

        for (Integer r : set) {
            System.out.print(r + " ");
        }
    }
}
