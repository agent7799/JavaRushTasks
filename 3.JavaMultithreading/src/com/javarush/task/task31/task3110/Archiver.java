package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;


public class Archiver {


    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Веедите операцию:");
        for (Operation op : Operation.values()) {
            ConsoleHelper.writeMessage(op.ordinal() + " - " + op.name());
        }

          return Operation.values()[ConsoleHelper.readInt()];
    }

    public static void main(String[] args) throws Exception {

//        Scanner scanner = new Scanner(System.in);
//        ConsoleHelper.writeMessage("Введите полный путь к файлу архива: ");
//        String zipFile = scanner.nextLine();
//        zipFile = "c:\\Java\\test.zip";
//        ConsoleHelper.writeMessage("По умолчанию полный путь к файлу архива: " + zipFile);
//        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(zipFile));
//
//        ConsoleHelper.writeMessage("Введите полный путь к архивируемому файлу: ");
//        String archivedFile = scanner.nextLine();
//        archivedFile = "c:\\Java\\test.txt";
//        ConsoleHelper.writeMessage("По умолчанию полный путь к архивируемому файлу: " + archivedFile);
//        zipFileManager.createZip(Paths.get(archivedFile));


        Operation operation = null;
        while (operation != Operation.EXIT) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }

    }

}
