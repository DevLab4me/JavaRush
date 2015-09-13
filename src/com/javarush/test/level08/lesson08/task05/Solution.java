package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main( String[] args )
    {
        HashMap<String, String> map = createMap();

        removeTheFirstNameDuplicates( map );
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> people = new HashMap<String, String>();
        people.put("Ivanov", "Sergey");
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

    public static void removeTheFirstNameDuplicates( HashMap<String, String> map )
    {
        Set<String> setNames = new HashSet<String>();
        Set<String> duplicateNames = new HashSet<String>();

        for ( Map.Entry<String, String> pair : map.entrySet() )
        {
            String name = pair.getValue();

            if ( setNames.contains( name ) )
            {
                duplicateNames.add( name );
            }
            else
            {
                setNames.add( name );
            }
        }

        for ( String name : duplicateNames )
        {
            removeItemFromMapByValue( map, name );
        }//Напишите тут ваш код

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
