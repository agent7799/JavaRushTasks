package com.javarush.task.task19.task1927;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();
        System.setOut(console);

       String[] strings = outputStream.toString().split("\\n");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
            if (i%2 != 0){
                System.out.println("JavaRush - курсы Java онлайн");
        }
       }

//        System.out.println(" ");
//
//        int lineCounter = 0;
//        int index = 0;
//        for (int i = 0 ; i < result.length(); i++){
//            if (result.charAt(i)=='\n'){
//                System.out.println(result.substring(index, i-1));
//                index = i+1;
//                lineCounter++;
//                if (lineCounter%2 == 0){
//                    System.out.println("JavaRush - курсы Java онлайн");
//                }
//                }
//            }




    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
