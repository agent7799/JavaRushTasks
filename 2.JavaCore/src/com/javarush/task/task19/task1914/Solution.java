package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String out = outputStream.toString();

        System.setOut(consoleStream);

        Pattern firstInt = Pattern.compile("\\[0-9]+");


        String[] strings = out.split(" ");

        int result = 0;

        switch (strings[1]) {
            case "+":
                result = Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]);
                break;
            case "-":
                result = Integer.parseInt(strings[0]) - Integer.parseInt(strings[2]);
                break;
            case "*":
                result = Integer.parseInt(strings[0]) * Integer.parseInt(strings[2]);
                break;
            default:
                System.out.println("error");
                break;
        }

//        for (String s : strings) {
//            System.out.println(s);
//        }

        System.out.println(strings[0] + " " + strings[1] + " " + strings[2] + " = " + result);


        //System.out.println(result.replaceAll("\\D", ""));

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

