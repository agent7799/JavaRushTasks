package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {

            ArrayList<String> strings = new ArrayList<>();

            while ((line = reader.readLine()) != null){
                String[] splitted = line.split(" ");
                for (int i = 0 ; i < splitted.length; i ++){
                    if (splitted[i].matches("(\\S{7,})") ){
                        strings.add(splitted[i]);
                        //System.out.println(splitted[i]);
                    }

                }
            }
                for (String s : strings){
                    System.out.println(s);
                }

                for (int i = 0; i < strings.size(); i++) {
                    System.out.println("i : " + i + " " + strings.get(i));
                    writer.write(strings.get(i));
                    if (i < strings.size() - 1) {
                        System.out.println(",");
                        writer.write(",");
                    }

                }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
