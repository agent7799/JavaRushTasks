package com.javarush.task.task20.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {FileInputStream fileInputStream = new FileInputStream(Statics.FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));


            String line;
            while (reader.ready()){
                line = reader.readLine();
                lines.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        System.out.println(lines);
    }
}
