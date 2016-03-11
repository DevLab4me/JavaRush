package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Artem on 18.11.2015.
 */

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;             // начальная сумма, стоимость рекламы в копейках
    private int hits;                       // количество оплаченных показов
    private int duration;                   // продолжительность в секундах
    private long amountPerOneDisplaying;    // стоимость одного показа рекламного объявления в копейках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount/hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
    public void revalidate() throws UnsupportedOperationException{
        if (hits > 0) {
            hits--;
            if (hits == 1)
                amountPerOneDisplaying = amountPerOneDisplaying + initialAmount % hits;
        } else
            throw new UnsupportedOperationException();
    }
}
