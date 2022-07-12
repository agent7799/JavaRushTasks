package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        ConsoleHelper.writeMessage("Список доступных блюд: " + Dish.allDishesToString());
        ConsoleHelper.writeMessage("Выберите блюдо или введите \"exit\" для выхода:");
        List<Dish> selectedDishes = new ArrayList<>();
        String dish;
        while (!(dish = readString()).equalsIgnoreCase("exit")) {
            try {
                for (String s : Dish.allDishesToString().split(" ")) {
                    //System.out.println("s = " + s + " ,dish = " + dish);
                    if (s.equalsIgnoreCase(dish)) {
                        selectedDishes.add(Dish.valueOf(s));
                        //System.out.println(s + " added");
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("Такого блюда нет, повторите выбор или введите \"exit\" для выхода:");
            }
        }
        return selectedDishes;
    }
}
