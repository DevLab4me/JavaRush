package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Artem on 18.11.2015.
 */

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds){
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException{
        List<Advertisement> videos = storage.list();
        if (videos.isEmpty()) throw new NoVideoAvailableException();

        Collections.sort(videos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                if (result == 0) {
                    result = Long.compare(
                            o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration(),
                            o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                }
                return result;
            }
        });

        for (Advertisement advertisement : storage.list()){
            if (timeSeconds >= advertisement.getDuration()) {
                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                        advertisement.getName(),
                        advertisement.getAmountPerOneDisplaying(),
                        advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
                advertisement.revalidate();
            }
        }
    }
}