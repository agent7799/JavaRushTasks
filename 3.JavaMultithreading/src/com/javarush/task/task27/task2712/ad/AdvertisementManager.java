package com.javarush.task.task27.task2712.ad;

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

        } else if (
            //если текущая стоимость больше максимальной
                currentAmount > maxAmount

                // или равна макимальной
                || currentAmount == maxAmount &&

                        //и оставшееся время totalTimeSecondsLeft больше времени приготовления заказа
                        (totalTimeSecondsLeft > currentTimeSecondsLeft

                                // или оставшееся время равно
                                || totalTimeSecondsLeft == currentTimeSecondsLeft

                                // и количество роликов меньше оптимального
                                && totalList.size() < optimalVideoSet.size())) {

            //то (оптимальные) поля принимают текущие значения
            this.totalTimeSecondsLeft = currentTimeSecondsLeft;
            this.optimalVideoSet = totalList;
            this.maxAmount = currentAmount;
            if (currentTimeSecondsLeft == 0) {
                return;
            }
        }
        //получаем список актуальных роликов
        ArrayList<Advertisement> tmp = getActualAdvertisements();
        tmp.removeAll(totalList);
        for (Advertisement ad : tmp) {
            if (!ad.isActive()) continue;
            ArrayList<Advertisement> currentList = new ArrayList<>(totalList);
            currentList.add(ad);

            //рекурсия
            obtainOptimalVideoSet(currentList, currentTimeSecondsLeft - ad.getDuration(), currentAmount + ad.getAmountPerOneDisplaying());
        }
    }


    //показываем ролики из оптимального набора
    private void displayAdvertisement() {
        if (optimalVideoSet == null || optimalVideoSet.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        //сортировка оптимального набора по цене одного показа, а потом длительности
        optimalVideoSet.sort((o1, o2) -> {
            long l = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
            return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());
        });

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