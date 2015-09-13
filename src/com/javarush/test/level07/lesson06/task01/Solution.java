package com.javarush.test.level07.lesson06.task01;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/

import java.util.ArrayList;

public class Solution
{
    final static int LINES_QTY = 5;
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();

        for ( int i = 0; i < LINES_QTY; i++ )
        {
            list.add( "String" + i );
        }

        System.out.println( list.size() );
        System.out.println( list );

    }
}
