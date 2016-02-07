package com.javarush.test.More.TestStudies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Artem on 18.11.2015.
 */

public class sortComparator {
    public static void main(String[] args) {
        List<Long> ads = new ArrayList<>();
        ads.add(2l);
        ads.add(5l);
        ads.add(23l);
        ads.add(12l);

        Collections.sort(ads, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return Long.compare(o1, o2);
            }
        });


        for (long l : ads){
            System.out.println(l);
        }
    }
}
