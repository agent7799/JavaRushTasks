package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();

       // args[0] = "\\c:\\java\\test.txt";
       // args[1] = "\\c:\\java\\test1.txt";



        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

            //Pattern pattern = Pattern.compile("[0-9]");


            while (reader.ready()){

                String[] splited = reader.readLine().split( " ");
                for (int i = 0; i < splited.length; i++) {
                    if (splited[i].matches(".*\\d.*")) {
                        writer.write(splited[i] + " ");
                        //System.out.println("Wrote: "  + splited[i]);
                        }
                    }

                }

            reader.close();

            for (String s : strings){
                //System.out.println(s);
                //writer.write(s + " ");
            }

            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
