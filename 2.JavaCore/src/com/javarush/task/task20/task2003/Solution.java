package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties properties = new Properties();
        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()){
           properties.setProperty(entry.getKey(), entry.getValue());
        }
        properties.store(outputStream, "app prop");

    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
    Properties properties = new Properties();
    properties.load(inputStream);


        for (Map.Entry<Object, Object> map : properties.entrySet()){
            runtimeStorage.put((String) map.getKey(), (String) map.getValue());
        }


    }

    public static void main(String[] args) {

        String path = "c:\\java\\app.properties";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           FileInputStream fos = new FileInputStream(reader.readLine())) {
          // FileInputStream fos = new FileInputStream(path) {     //   String path = "c:\\java\\app.properties";
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(runtimeStorage);
    }
}
