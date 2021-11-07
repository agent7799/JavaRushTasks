package com.javarush.task.task16.task1633;

/* 
Отдебажим все на свете
*/

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);


        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

        threadA.setUncaughtExceptionHandler(handler);
        threadB.setUncaughtExceptionHandler(handler);

        /*Для класса TestedThread создан конструктор в котором выполняется установка
        setUncaughtExceptionHandler(handler) и, может показаться, что этого достаточно. Но далее мы создаем две нити
        threadA и threadB, передавая им в качестве параметра объект класса commonThread. Который при передаче сужается
        до объекта Runnable(смотря аргументы конструктора Thread). Таким образом информация об необходимом обработчике
        не поступает в конструктор нитей. Для того чтобы всетаки установить обработчик, после создания нитей надо явно
        указать для них обработчики строками threadA.setUncaughtExceptionHandler(handler);
        и threadB.setUncaughtExceptionHandler(handler);
         */

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            Thread.currentThread().setUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
