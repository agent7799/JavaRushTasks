package com.javarush.task.task23.task2311;

/* 
Повторяем threads
Мы не можем просто сделать статическим метод sleep в Solution, потому что потеряем возможность использовать в нем нестатические переменные класса Solution (в частности name, который нам нужен), так что этот вариант не годится. Сбросьте задачу и начните сначала.

Наша проблема заключается в том, что у нас имеется два метода sleep: статический (вшитый в класс Thread, которым мы пользовались при работе с многопоточностью) и нестатический (самописный, который лежит в Solution).

Так как анонимный класс, который вызывает метод  someActions, является наследником класса Thread, то первым делом он пытается использовать свой дефолтный статический sleep.
Наша задача - заставить его использовать наш sleep, явно указав на него:
Solution.this.sleep(1000);
*/

public class Solution {
    public final String name;
    public final String food;
    public final String sound;

    public Solution(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }

    public void sleep(long milliseconds) {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " s");
    }

    public void live() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    someActions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                eat();
                play();
                Solution.this.sleep(1000);
            }
        };
        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new Solution("Amigo", "beef", "knock").live();
    }
}
