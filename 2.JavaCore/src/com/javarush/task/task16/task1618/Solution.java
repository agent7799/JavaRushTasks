package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread thread = new TestThread();
        thread.start();

        thread.interrupt();
        System.out.println("thread stopped");

    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        public void run(){
            System.out.println("thread started");
        }
    }
}