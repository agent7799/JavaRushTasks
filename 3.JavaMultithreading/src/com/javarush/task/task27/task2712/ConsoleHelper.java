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
        ConsoleHelper.writeMessage("Выберите блюдо из списка: \n" + Dish.allDishesToString() +  "\nили введите \"exit\" для выхода:");
        List<Dish> selectedDishes = new ArrayList<>();
        
        while (true) {
            String dishName = ConsoleHelper.readString().trim();
            if("exit".equalsIgnoreCase(dishName)){
                break;
            }
            try {
                Dish dish = Dish.valueOf(dishName.toUpperCase());
                        selectedDishes.add(dish);
                        System.out.println(dish + " added to order");
                }catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("Такого блюда нет, повторите выбор или введите \"exit\" для выхода:");
            }
        }
        return selectedDishes;
    }
}
