package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        ZipFileManager manager = getZipFileManager();
        try {
            ConsoleHelper.writeMessage("Создание архива.");
            ConsoleHelper.writeMessage("Введите полный путь к файлу или директории для архивации: ");
            String fileToBeArchived = ConsoleHelper.readString();
//            archivedFile = "c:\\Java\\test.txt";
//            ConsoleHelper.writeMessage("По умолчанию полный путь к архивируемому файлу: " + fileToBeArchived);

            Path path = Paths.get(fileToBeArchived);

            manager.createZip(path);
            ConsoleHelper.writeMessage("Архив создан.");
        }catch (PathIsNotFoundException e){
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
