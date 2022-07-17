package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        ConsoleHelper.writeMessage(toString());
    }

    @Override
    public String toString() {
        String result = "";
        if (dishes.size() == 0) {
            return result;
        } else {
            result += "Your order: [" + dishes.get(0);
            for (int i = 1; i < dishes.size(); i++) {           // !!  from i = 1 !!
                result += ", " + dishes.get(i).name();
            }
            result += "] of " + tablet;
            result += ", cooking time " + getTotalCookingTime() + "min";
            return result;
        }
    }

    public boolean isEmpty(){
        return (dishes.size() == 0);
    }

    public int getTotalCookingTime(){
        int totalCookingTime = 0;
        for (Dish d : dishes) {
            totalCookingTime += d.getDuration();
        }
        return totalCookingTime;
    }

}

