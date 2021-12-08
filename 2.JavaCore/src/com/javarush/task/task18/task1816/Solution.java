package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {



    public static void main(String[] args) {

        try {
            int count = 0;
            char symbol;
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            while (reader.ready()){
                symbol = (char) reader.read();

                if (symbol>= 'a' && symbol <= 'z' || symbol>='A' && symbol<='Z'){
                    //System.out.println(symbol);
                    count++;
                }

            }
            System.out.println(count);
            reader.close();





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
