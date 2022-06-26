package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
            try {
                ConsoleHelper.writeMessage("Распаковка архива.");

                ZipFileManager zipFileManager = getZipFileManager();

                ConsoleHelper.writeMessage("Введите полный путь распаковки архива:");
                Path unZipFilePath = Paths.get(ConsoleHelper.readString());

                zipFileManager.extractAll(unZipFilePath);

                ConsoleHelper.writeMessage("Архив создан.");
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
            }
        }
}
