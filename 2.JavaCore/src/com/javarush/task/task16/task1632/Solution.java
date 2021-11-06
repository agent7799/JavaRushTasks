package com.javarush.task.task16.task1632;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
        for (Thread i : threads){
            i.start();
        }

    }

    public static class Thread1 extends Thread implements Runnable{
        public void run() {
            //System.out.println("thread1 alive");
            while (!isInterrupted()){
            }
        }
    }

    public static class Thread2 extends Thread implements Runnable{
        public void run() {
            try {
            throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
                //e.printStackTrace();
            }
        }
    }

    public static class Thread3 extends Thread implements Runnable{
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                try {
                    System.out.println("Ура!");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static class Thread4 extends Thread implements Message {

        public void run() {
            while (!isInterrupted()){
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Thread5 extends Thread implements Runnable{
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(System.in);

            String s = "";
            int i = 0;
            while (!s.equals("N")) {
                s = scanner.nextLine();
                i = i + Integer.parseInt(s);
                System.out.println(i);
            }
            System.out.println(i);
        }
    }



}