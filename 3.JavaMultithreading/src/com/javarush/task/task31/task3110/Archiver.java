package com.javarush.task.task31.task3110;

import java.nio.file.Paths;
import java.util.Scanner;



public class Archiver {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter full path to .zip file:");
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(scanner.nextLine()) );

        System.out.println("Enter full path to file to be archived:");
        zipFileManager.createZip(Paths.get(scanner.nextLine()));
    }

}
