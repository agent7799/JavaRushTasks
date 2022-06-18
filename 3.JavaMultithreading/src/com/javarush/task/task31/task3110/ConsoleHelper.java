package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleHelper {

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String result;
        try(Scanner scanner = new Scanner(System.in)){
            result = scanner.nextLine();
        }
        return result;
    }

    public static int readInt() throws  IOException{
        int result;
        try(Scanner scanner = new Scanner(System.in)){
            result = scanner.nextInt();
        }
        return result;
    }


}
