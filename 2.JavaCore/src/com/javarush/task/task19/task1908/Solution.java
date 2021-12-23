package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
//            String firstFileName = "c:\\java\\test.txt";
//            String secondFileName = "c:\\java\\test1.txt";

            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(firstFileName));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFileName));

            //String regex  = "\\b\\d{1,}\\b";

            ArrayList<String> list = new ArrayList<String>();

            while (fileReader.ready()) {
                for (String str : fileReader.readLine().split(" ")){
                    if (str.matches("\\b\\d{1,}\\b")){
                        fileWriter.write(str + " ");
                        //list.add(str);
                        System.out.println(str);
                    }
                }

//                for(String s : list){
//                    fileWriter.write(s + " ");
//                    //System.out.println(s);
//                }
                //text.append(Arrays.toString(s.split(" ")));
               //text.matches("\\b\\d{1,}\\b")));
            }


            //System.out.println(list);

            fileReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

public static boolean isNumeric(String str){
        return str.matches("\\b\\d{1,}\\b");
}

}
