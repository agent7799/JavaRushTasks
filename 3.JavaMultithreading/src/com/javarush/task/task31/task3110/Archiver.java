package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.nio.file.Paths;
import java.util.Scanner;



public class Archiver {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        ConsoleHelper.writeMessage("Введите полный путь к файлу архива: ");
        String zipFile = scanner.nextLine();
        zipFile = "c:\\Java\\test.zip";
        ConsoleHelper.writeMessage("По умолчанию полный путь к файлу архива: " + zipFile);
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(zipFile) );

        ConsoleHelper.writeMessage("Введите полный путь к архивируемому файлу: ");
        String archivedFile = scanner.nextLine();
        archivedFile = "c:\\Java\\test.txt";
        ConsoleHelper.writeMessage("По умолчанию полный путь к архивируемому файлу: " + archivedFile);
        zipFileManager.createZip(Paths.get(archivedFile));

        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }

}
