package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] strings = message.split(":");
            if (strings.length != 2) {
                return;
            }
                String name = strings[0].trim();
                String text = strings[1].trim();
                SimpleDateFormat dateFormat;
                switch (text) {
                    case "дата":
                        dateFormat = new SimpleDateFormat("d.MM.yyyy");
                        break;
                    case "день":
                        dateFormat = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        dateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        dateFormat = new SimpleDateFormat("yyyy");
                        break;
                    case "время":
                        dateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        dateFormat = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        dateFormat = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        dateFormat = new SimpleDateFormat("s");
                        break;
                    default: return;
                }
                Date time = Calendar.getInstance().getTime();
                sendTextMessage(String.format("Информация для %s: %s", name, dateFormat.format(time)));
            }
        }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    public String getUserName() {
        int number = (int) (Math.random() * 100);
        return "date_bot_" + number;
    }


    public static void main(String[] args) {
        new BotClient().run();
    }
}
