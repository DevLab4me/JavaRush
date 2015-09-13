package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();

        System.out.println(getCountTheSameFirstName(map, "Vasilij"));
        System.out.println(getCountTheSameLastName(map, "Ivanov"));
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> people = new HashMap<String, String>();
        people.put("Ivanov", "Petr");
        people.put("Petrov", "Vasilij");
        people.put("Sidorov", "Sergey");
        people.put("Smirnov", "Pyotr");
        people.put("Nemiroff", "Vasilij");
        people.put("Ivanova", "Sofia");
        people.put("Macalan", "John");
        people.put("Smirnoff", "Vovochka");
        people.put("Jameson", "John");
        people.put("Napoleone", "Buonaparte");

        return people;//Напишите тут ваш код

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String value = pair.getValue();
            if (name.equals(value))
            {
                count++;
            }
        }

        return count;//Напишите тут ваш код

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        return map.containsKey(familiya) ? 1 : 0;//Напишите тут ваш код

    }
}
