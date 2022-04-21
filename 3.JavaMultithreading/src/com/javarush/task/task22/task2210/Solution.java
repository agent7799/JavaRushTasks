package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        List<String> strings = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()){
            strings.add(tokenizer.nextToken());
        }

        String[] result = strings.toArray(new String[0]);

        for (String s: result) {
            System.out.println(s);
        }


        return (result);
    }
}
