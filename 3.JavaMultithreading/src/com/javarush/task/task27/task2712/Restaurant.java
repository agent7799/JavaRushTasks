package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

import java.io.IOException;

public class Restaurant {


    public static void main(String[] args) throws IOException {


        Tablet tablet = new Tablet(1);
        tablet.addObserver(new Cook("Amigo"));
        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();

    }
}
