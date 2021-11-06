package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {
    public static void main(String[] args) {

    }

        interface CanFly {
            void fly();
        }

        interface CanClimb {
            void climb();
        }

        interface CanRun {
            void run();
        }

        class Cat implements CanClimb, CanRun {
            @Override
            public void climb() {
            }

            @Override
            public void run() {
            }
        }

        class Dog implements CanRun {

            @Override
            public void run() {
            }
        }

        class Tiger extends Cat {
            @Override
            public void climb() {
            }

            @Override
            public void run() {
            }

        }

        class Duck implements CanFly , CanRun {
            @Override
            public void fly() {
            }

            @Override
            public void run() {
            }
        }



}



