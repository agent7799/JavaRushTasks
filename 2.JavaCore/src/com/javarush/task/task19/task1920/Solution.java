package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {



        //File file = new File(args[0]);
        String file = args[0];

        TreeMap<String, Double> map = new TreeMap<String, Double>();



        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s = null;
            String key;
            Double val;

            while (reader.ready()){
                s = reader.readLine();
                key = s.substring(0, s.indexOf(' '));
                val = Double.parseDouble(s.substring(s.indexOf(' ')+1));
                if (map.keySet().contains(key)){
                    val = map.get(key) + val;
                }
                map.put(key, val);
                //System.out.println(map.get(key) + val);
                //System.out.println("key: " + key + " val: "  +val);
                //map.put(s.substring(0, s.indexOf(' ')),Double.parseDouble(s.substring(s.indexOf(' ')+1)));
            }
            reader.close();

            Double maxValue = Collections.max(map.values());

            ArrayList<String> maxValuesSorted = new ArrayList<>();

            for(Map.Entry<String, Double> entry : map.entrySet()){
                //System.out.println(entry.getKey() + " " +  entry.getValue());
                if (Objects.equals(entry.getValue(), maxValue)){
                    System.out.println(entry.getKey());
                    //maxValuesSorted.add(entry.getKey());
                //System.out.println(entry.getKey());
                }

            }
           // Collections.sort(maxValuesSorted);

            //System.out.println(maxValuesSorted);




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
