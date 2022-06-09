package com.javarush.task.task30.task3008.client;

public class BotClient extends Client{

    public class BotSocketThread extends SocketThread{
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
