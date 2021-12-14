package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String s = scanner.nextLine();
            if(s.equals("exit")){
                break;
            }
            new ReadThread(s).start();
        }

        scanner.close();

    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут


        public String getFileName() {
            return fileName;
        }

        @Override
        public void run() {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                ArrayList<Integer> bytes = new ArrayList<>();
                Map<Integer, Integer> byteMap = new TreeMap<>();

                Integer byteFromFile;
                while (reader.ready()) {
                    byteFromFile = reader.read();
                    bytes.add(byteFromFile);
                    byteMap.put(byteFromFile, 0);
                }

                for (Integer map : byteMap.keySet()) {
                    for (Integer b : bytes) {
                        if (map.equals(b)) {
                            int count = byteMap.getOrDefault(map, 0);
                            byteMap.put(map, count + 1);
                        }
                    }
                }

                for (Map.Entry<Integer, Integer> entry : byteMap.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }

                int maxValueInMap = (Collections.max(byteMap.values()));  // This will return max value in the HashMap
                for (Map.Entry<Integer, Integer> entry : byteMap.entrySet()) {  // Iterate through HashMap
                    if (entry.getValue() == maxValueInMap) {
                        resultMap.put(fileName, entry.getKey());     // Print the key with max value
                    }
                }

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
