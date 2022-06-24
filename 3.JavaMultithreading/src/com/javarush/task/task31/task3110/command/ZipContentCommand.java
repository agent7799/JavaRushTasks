package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.FileProperties;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.util.List;

public class ZipContentCommand extends ZipCommand{
    @Override
    public ZipFileManager getZipFileManager() throws Exception {
        return super.getZipFileManager();
    }

    @Override
    public void execute() throws Exception {

        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        List<FileProperties> filePropertiesList = zipFileManager.getFilesList();
        for (FileProperties f : filePropertiesList) {
            ConsoleHelper.writeMessage(f.toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
