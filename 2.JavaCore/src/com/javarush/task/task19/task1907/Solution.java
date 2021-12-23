package com.javarush.task.task19.task1907;

import java.io.*;

/* 
Считаем слово
*/

public class Solution {
    private static int counter = 0;

    public static void main(String[] args) throws IOException {

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


//        try {
//           // String firstFileName = reader.readLine();
//            String firstFileName = "c:\\java\\test.txt";
//
//            reader.close();
//
//            BufferedReader reader1 = new BufferedReader(new FileReader(firstFileName));
//            int count = 0;
//            while (reader1.ready()) {
//                String s = reader1.readLine();
//                if (s.contains("world")) {
//                    count++;
//                }
//            }
//            reader1.close();
//            System.out.println(count);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



            String fileName;

            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                //fileName = br.readLine();
                fileName = "c:\\java\\test.txt";
            }

            StringBuilder text = new StringBuilder();
            try (FileReader reader = new FileReader(fileName)) {
                char currentChar;
                while (reader.ready()) {
                    currentChar = (char) reader.read();
                    text.append(currentChar);

                }
            }

            String replacedString = text.toString().replaceAll("\\p{P}", " ").replaceAll("\\s", " ");

            for (String x : replacedString.split(" ")) {
                if (x.equals("world")) {
                    counter++;
                }
            }

            System.out.println(counter);

        }

}
