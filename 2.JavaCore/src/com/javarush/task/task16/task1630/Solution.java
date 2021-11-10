package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
//        Scanner scanner = new Scanner(System.in);
//        firstFileName = scanner.nextLine();
//        secondFileName = scanner.nextLine();
//        scanner.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();

//            firstFileName = "c:\\java\\test.txt";
//            secondFileName = "c:\\java\\test.txt";

//            System.out.println(firstFileName);
//            System.out.println(secondFileName);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
        //add your code here - добавьте код тут

    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String result = "";

        @Override
        public void setFileName(String fullFileName)
        {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent()
        {
            return result;
        }


        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                result = reader.lines().collect(Collectors.joining(" "));
                reader.close();

                Scanner scanner = new Scanner(new File(fileName));
                StringBuilder stringBuilder = new StringBuilder();
                while (scanner.hasNextLine()){
                    stringBuilder.append(scanner.nextLine());
                    stringBuilder.append(" ");
                   // stringBuilder.substring(0, -1);
                    result = stringBuilder.toString();
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
//            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
//                while (fileReader.ready()) {
//                    result = result + fileReader.readLine() + " ";
//                    //System.out.println(fileReader.readLine());
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println(result);
//        }
    }

        public interface ReadFileInterface {

            void setFileName(String fullFileName);

            String getFileContent();

            void join() throws InterruptedException;

            void start();
        }

        //add your code here - добавьте код тут




}
