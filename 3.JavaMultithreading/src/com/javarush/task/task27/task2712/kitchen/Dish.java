package com.javarush.task.task27.task2712.kitchen;

import java.util.ArrayList;
import java.util.Collections;

public enum Dish {
        FISH, STEAK, SOUP, JUICE, WATER;

    public static String allDishesToString(){
        ArrayList<Dish> list = new ArrayList<>();
        Collections.addAll(list, values());
        StringBuilder sb = new StringBuilder();

        for (Dish d : list) {
            sb.append(d.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
