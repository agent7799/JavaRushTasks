package com.javarush.task.task27.task2712.ad;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class StatisticAdvertisementManager {
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager(){
    }

    private static class InstanceHolder {
        public static final StatisticAdvertisementManager HOLDER_INSTANCE = new StatisticAdvertisementManager();
    }

    public static StatisticAdvertisementManager getInstance() {
        return InstanceHolder.HOLDER_INSTANCE;
    }



    public LinkedList<Advertisement> getVideos(boolean active){
         LinkedList<Advertisement> videos = new LinkedList<>();
        for (Advertisement ad : AdvertisementStorage.getInstance().list()) {
            if (ad.isActive() == active){
                videos.add(ad);
            }
        }

        Collections.sort(videos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });

        return videos;
    }

}
