package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;



    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }



    public static void main(String[] args) {
        ArrayList<Horse> horses = new ArrayList<>();
        game = new Hippodrome(horses);

        horses.add(new Horse("Belka", 3, 0));
        horses.add(new Horse("Strelka", 3, 0));
        horses.add(new Horse("Venera", 3, 0));
    }

    void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void move(){
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
            
        }
    }

    void print(){

    }
}
