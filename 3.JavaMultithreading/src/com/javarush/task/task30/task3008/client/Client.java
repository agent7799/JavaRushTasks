package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.*;

import java.io.IOException;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;


    public class SocketThread extends Thread {

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }


    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage("Error sending message");
        }

    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

            try {
                synchronized (this) {
                this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (clientConnected) {
                ConsoleHelper.writeMessage("Соединение установлено.\n" +
                        "Для выхода наберите команду 'exit'.");
            } else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }


        while (clientConnected) {
            String text = ConsoleHelper.readString();
            if (text.equalsIgnoreCase("exit")) {
                break;
            }
            if (shouldSendTextFromConsole()) {
                sendTextMessage(text);
            }
        }


    }


}
