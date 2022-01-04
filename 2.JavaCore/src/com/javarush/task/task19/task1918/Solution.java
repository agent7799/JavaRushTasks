package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {

        try {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //String fileName =reader.readLine();
     String fileName = "c:\\java\\test.txt";
    reader.close();

    BufferedReader fileReader = new BufferedReader(new FileReader(fileName));


    String temp = "";

    while (fileReader.ready()){
        temp = temp + fileReader.readLine().replace("\n","");
    }
            System.out.println("Input string: " + temp);
            System.out.println(" ");
            String tagStart = "<" + args[0];

            String tagEnd = "</" + args[0] +">";
            //System.out.println("Tag Start: " + tagStart);
            //System.out.println("Tag Start: " + tagEnd);


            ArrayList<Integer> indexTagBegins = new ArrayList<>();
            ArrayList<Integer> indexTagEnds = new ArrayList<>();


            int indexStart = 0;
            int indexEnd = 0;
            int index = 0;

            for (int i = 0 ; i < temp.length() ; i ++) {
                indexStart = temp.indexOf(tagStart, i);
                if (indexStart > 0 && indexStart < temp.length()) {
                    indexTagBegins.add(indexStart);
                    //System.out.println("i=" + i + " tag starts " + temp.indexOf(tagStart, i));
                    i = indexStart;
                }
            }
                for (int i = 0 ; i < temp.length() ; i ++) {
                    indexEnd = temp.indexOf(tagEnd, i);
                    if (indexEnd > 0 && indexEnd < temp.length()) {
                        indexTagEnds.add(indexEnd);
                        //System.out.println("i=" + i + " tag ends " + temp.indexOf(tagEnd, i));
                        i = indexEnd;
                    }
                }



//    for (int i = 0; i < indexTagEnds.size(); i++) {
//        if (indexTagEnds.get(i) < indexTagBegins.get(i + 1)) {
//            System.out.println("norm");
//            System.out.println(temp.substring(indexTagBegins.get(i), indexTagEnds.get(i) + tagEnd.length()));
//
//        } else {
//            int t = i;
//            while (indexTagEnds.get(t) > indexTagBegins.get(t + 1) && (t + 1) < indexTagBegins.size()) {
//                t++;
//            }
//            System.out.println("while");
//            System.out.println(temp.substring(indexTagBegins.get(i), indexTagEnds.get(t) + tagEnd.length()));
//
//        }


    while (!indexTagBegins.isEmpty()){
        int start = indexTagBegins.get(0);
        int end = indexTagEnds.get(0) + tagEnd.length();
        for (int i = 0; i <indexTagBegins.size() ; i++) {
            if (end > indexTagBegins.get(i)){
                end = indexTagEnds.get(i);
            } else break;

            System.out.println(temp.substring(start, end + tagEnd.length()));

        }

        indexTagBegins.remove(start);
        indexTagEnds.remove(end);
    }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
