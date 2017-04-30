package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

/**
 * Created by Artem on 12/20/2016.
 */
public class Shortener
{
    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string){
        if (storageStrategy.containsValue(string)) {
            // если есть – вернуть его ключ
            return storageStrategy.getKey(string);
        }
        //Если преданного значения нет в хранилище, то:
        else {
            //Увеличить значение lastId
            lastId ++;
            //Добавить в хранилище новую пару ключ-значение (новое значение lastId и переданную строку)
            storageStrategy.put(lastId, string);
            //Вернуть новое значение lastId
            return lastId;
        }
    }

    public synchronized String getString(Long id){
        if (storageStrategy.containsKey(id)) {
            return storageStrategy.getValue(id);
        }
        else {
            return null;
        }
    }
}
