package com.javarush.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        //сделайте что-то тут - do something here
        try {
            Thread.sleep(1000);
            synchronized (mail){
                mail.setText("Person [" + name + "] wrote an email 'AAA'");
                //сделайте что-то тут - do something here
                mail.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}