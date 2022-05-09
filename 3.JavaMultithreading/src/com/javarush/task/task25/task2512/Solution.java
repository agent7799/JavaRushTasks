package com.javarush.task.task25.task2512;

/*
Живем своим умом
В классе Solution реализуй интерфейс UncaughtExceptionHandler,
который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        List<String> strings = new ArrayList<>();
        while (e != null){
            strings.add(e.getClass().getName() + ": " + e.getMessage());
            e = e.getCause();
        }

        Collections.reverse(strings);
        for (String s : strings) {
            System.out.println(s);
        }

    }

    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
                throw new RuntimeException
                        ("ABC", new Exception
                                ("DEF", new IllegalAccessException("GHI")));
            }
        };
        t.setUncaughtExceptionHandler(new Solution());
        t.start();
    }
}
