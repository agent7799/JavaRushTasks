package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;



    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
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
        //IntStream.range(0, horses.size()).forEach(i -> horses.get(i).move());
        for (Horse horse: horses) {
            horse.move();
        }
    }

    void print(){
        //IntStream.range(0, horses.size()).forEach(i -> horses.get(i).print());
        for (Horse horse: horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }



    public static void main(String[] args) {
        ArrayList<Horse> horses = new ArrayList<>();
        game = new Hippodrome(horses);

        horses.add(new Horse("Slevin", 3, 0));
        horses.add(new Horse("Lucky", 3, 0));
        horses.add(new Horse("Number", 3, 0));

        game.run();
    }
}
