package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private List<Advertisement> optimalVideoSet;


    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        this.totalTimeSecondsLeft = Integer.MAX_VALUE;
        obtainOptimalVideoSet(new ArrayList<>(), timeSeconds, 0L);
        displayAdvertisement();
    }

    //recursion
    private long maxAmount;
    private int totalTimeSecondsLeft;

    private void obtainOptimalVideoSet(List<Advertisement> totalList, int currentTimeSecondsLeft, long currentAmount) {
        if (currentTimeSecondsLeft < 0) {
            return;
        } else if (currentAmount > maxAmount
                || currentAmount == maxAmount && (totalTimeSecondsLeft > currentTimeSecondsLeft
                || totalTimeSecondsLeft == currentTimeSecondsLeft && totalList.size() < optimalVideoSet.size())) {
            this.totalTimeSecondsLeft = currentTimeSecondsLeft;
            this.optimalVideoSet = totalList;
            this.maxAmount = currentAmount;
            if (currentTimeSecondsLeft == 0) {
                return;
            }
        }

        ArrayList<Advertisement> tmp = getActualAdvertisements();
        tmp.removeAll(totalList);
        for (Advertisement ad : tmp) {
            if (!ad.isActive()) continue;
            ArrayList<Advertisement> currentList = new ArrayList<>(totalList);
            currentList.add(ad);
            obtainOptimalVideoSet(currentList, currentTimeSecondsLeft - ad.getDuration(), currentAmount + ad.getAmountPerOneDisplaying());
        }
    }


    //показываем ролики из оптимального набора
    private void displayAdvertisement() {
        if (optimalVideoSet == null || optimalVideoSet.isEmpty()) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(totalTimeSecondsLeft));
            throw new NoVideoAvailableException();
        }

        //сортировка оптимального набора по цене одного показа, а потом длительности
        optimalVideoSet.sort((o1, o2) -> {
            long l = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
            return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());
        });

        //регистрация события показа в статистике
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(optimalVideoSet, maxAmount, totalTimeSecondsLeft));


        //показ и обновление статуса
        for (Advertisement ad : optimalVideoSet) {
            displayInPlayer(ad);
            ad.revalidate();
        }

    }

    //показ ролика
    private void displayInPlayer(Advertisement advertisement) {
        System.out.println(advertisement.getName() + " is displaying... " + advertisement.getAmountPerOneDisplaying() +
                ", " + (1000 * advertisement.getAmountPerOneDisplaying() / advertisement.getDuration()));
    }

    //получаем список активных роликов
    private ArrayList<Advertisement> getActualAdvertisements() {
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.isActive()) {
                advertisements.add(ad);
            }
        }
        return advertisements;
    }
}