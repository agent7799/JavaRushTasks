package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
         String message = null;
        while (true){
            try {
                message = bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                //e.printStackTrace();
                continue;
            }
            if (message!=null) {
                break;
            }
        }
        return message;
    }

    public static int readInt(){
        int result;
        while(true){
            try{
                result = Integer.parseInt(readString());
            }catch (NumberFormatException e){
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
                continue;
            }
            return result;
        }



    }




}
