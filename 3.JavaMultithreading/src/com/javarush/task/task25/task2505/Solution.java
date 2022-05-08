package com.javarush.task.task25.task2505;

/* 
Без дураков
Создай private class MyUncaughtExceptionHandler, который на перехват
 исключения должен подождать половину секунды, а затем вывести на экран
 secretKey, имя трэда и сообщение возникшего исключения.
Используй String.format(...)
*/


public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler()); //назначаем свой перехватчик исключений
            //setDaemon(true);                          //делаем поток не демоном
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }


        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler { //наследуемся от обработчика
            public MyUncaughtExceptionHandler() {       //конструктор по умолчанию
            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {  //переопределяем свой метод обработки
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                System.out.print(String.format("%s, %s, %s", MyThread.this.secretKey, t.getName(), e.getMessage()));
            }
        }
    }



}

