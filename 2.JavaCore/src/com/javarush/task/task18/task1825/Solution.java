package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> namesMap = new TreeMap<>();

        String outputFileName = null;

        try {
            while (true) {
                String s = scanner.nextLine();
                if (s.equals("end")) {
                    break;
                }

                int partIndex = s.indexOf(".part");
                System.out.println("partIndex = " + partIndex);
                if (outputFileName == null) {
                    outputFileName = s.substring(0, partIndex);
                }


                Integer key = Integer.parseInt(s.substring(partIndex + 5));
                System.out.println("key = " + key);
                System.out.println("s = " + s);
                namesMap.put(key, s);

            }

            scanner.close();

            if (outputFileName != null){
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName, true)));
                String tempFileName;
                for (Map.Entry<Integer, String> entry : namesMap.entrySet()) {
                    tempFileName = entry.getValue();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(tempFileName)));

                    while (reader.ready()){
                        writer.write(reader.read());
                    }
                    reader.close();
                }
                writer.close();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


