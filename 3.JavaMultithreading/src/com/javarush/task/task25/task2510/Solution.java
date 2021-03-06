package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
Все исключения, которые возникают в процессе работы нити Solution, должны быть обработаны одним из вариантов:
1. Если это Error, то вывести в консоль "Нельзя дальше работать".
2. Если это Exception, то вывести в консоль "Надо обработать".
3. Если это Throwable, то вывести в консоль "Поживем - увидим".
Реализуй эту логику.
*/

public class Solution extends Thread {

    public Solution() {
        this.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String message;
                if (e instanceof Error) {
                    message = "Нельзя дальше работать";
                } else if (e instanceof Exception) {
                    message = "Надо обработать";
                } else {
                    message = "Поживем - увидим";
                }
                System.out.println(message);
            }


        });

    }

    public static void main(String[] args) {
    }
}
