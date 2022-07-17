package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvertisementManager  {
    
    private int timeSeconds;

    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> availableVideos = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.getDuration() <= timeSeconds) {
                availableVideos.add(ad);
            }
        }
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        } else {
            Collections.sort(availableVideos, (o1, o2) -> (int) ((o1.getAmountPerOneDisplaying()) - o2.getAmountPerOneDisplaying()));
            for (Advertisement a : availableVideos) {
                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                        a.getName(), a.getDuration(), a.getAmountPerOneDisplaying()));
            }
        }



    }


}
