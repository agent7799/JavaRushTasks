package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client{

    public class BotSocketThread extends SocketThread{

        @Override
        protected  void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
                super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            System.out.println(message);
            if(message.contains(": ")){
                String name = message.substring(0, message.indexOf(": "));
                String text = message.substring(message.indexOf(": ") + 2);
                SimpleDateFormat dateFormat;
                String responseText;
                Date date = Calendar.getInstance().getTime();
                switch (text) {
                    case "дата" :
                        dateFormat = new SimpleDateFormat("d.MM.YYYY");
                        responseText = dateFormat.format(date);
                        sendTextMessage("Информация для " + name + ": " + responseText + ".");
                    case "день" :
                        dateFormat = new SimpleDateFormat("d");
                    case "месяц" :
                        dateFormat = new SimpleDateFormat("MMMM");
                    case "год" :
                        dateFormat = new SimpleDateFormat("YYYY");
                    case "время" :
                        dateFormat = new SimpleDateFormat("H:mm:ss");
                    case "час" :
                        dateFormat = new SimpleDateFormat("H");
                    case "минуты" :
                        dateFormat = new SimpleDateFormat("m");
                    case "секунды" :
                        dateFormat = new SimpleDateFormat("s");
                }
            }

        }
    }

    @Override
    protected SocketThread getSocketThread(){
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole(){
        return false;
    }

    public String  getUserName(){
        int number = (int) (Math.random()*100);
        return new String("date_bot_" + number);
    }


    public static void main(String[] args) {
        new BotClient().run();
    }
}
