package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

public class StatisticManager {

    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    //singleton
    private StatisticManager() {
    }
    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    //private inner class
    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
//            this.storage = storage;
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }
        }

        private void put(EventDataRow data){
            //получаем значение (ArrayList) из мапы storage по ключу data.getType() - ".get(data.getType())"
            // и тут же в него добавляем data - .add(data)
            EventType type = data.getType();
            storage.get(type).add(data);
        }

    }

    public void register(EventDataRow data) {
        this.statisticStorage.put(data);
    }

    public void register(Cook cook){
        cooks.add(cook);
    }



}
