package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {

            String secondFileName = reader.readLine();

            //String secondFileName = "c:\\java\\test1.txt";
            reader.close();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream consoleStream = System.out;

            PrintStream stream = new PrintStream(outputStream);
            System.setOut(stream);
            testString.printSomething();

            String out = outputStream.toString();

            System.setOut(consoleStream);
            System.out.println(outputStream);

            FileOutputStream fileStream = new FileOutputStream(secondFileName);
            fileStream.write(outputStream.toByteArray());

            fileStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

