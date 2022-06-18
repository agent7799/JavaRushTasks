package com.javarush.task.task31.task3110;

import java.nio.file.Paths;
import java.util.Scanner;



public class Archiver {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter full path to .zip file: ");
        String zipFile = scanner.nextLine();
        zipFile = "c:\\Java\\test.zip";
        System.out.println("Default is : " + zipFile);
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(zipFile) );

        System.out.println("Enter full path to file to be archived:");
        String archivedFile = scanner.nextLine();
        archivedFile = "c:\\Java\\test.txt";
        System.out.println("Default is : " + archivedFile);
        System.out.println("Default: " + archivedFile);
        zipFileManager.createZip(Paths.get(archivedFile));
    }

}
