package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));

            ArrayList<Character> charSet = new ArrayList<>();
            Map<Character, Integer> map = new TreeMap<>();

            Character ch;
            while (reader.ready()) {
                ch = (char) reader.read();
                charSet.add(ch);
                map.put(ch, 0);
            }

                for (Character c : map.keySet()) {
                    for (Character arrayCh : charSet) {
                        if (c.equals(arrayCh)) {
                            int count = map.getOrDefault(c, 0);
                            map.put(c, count + 1);
                        }
                    }
                }

                for (Map.Entry<Character, Integer> entry : map.entrySet()){
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }

reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
