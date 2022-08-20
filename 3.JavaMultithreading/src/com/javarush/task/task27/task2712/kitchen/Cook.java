package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private final String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object order) {
        Order currentOrder = (Order) order;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
        //создаем экзепляр заказа и пишем в статистику событие
        CookedOrderEventDataRow row = new CookedOrderEventDataRow(currentOrder.getTablet().toString(), name, currentOrder.getTotalCookingTime()*60, currentOrder.getDishes());
        StatisticManager.getInstance().register(row);
    }

    @Override
    public String toString() {
        return name;
    }
}
