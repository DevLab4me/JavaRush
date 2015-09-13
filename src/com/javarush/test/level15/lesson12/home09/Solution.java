package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Object> list = new ArrayList<Object>();
        String newString = reader.readLine();
        String s1 = "[?]";
        String[] subStrings = newString.split(s1);

        String subString2[] = new String[subStrings.length-1];
        for(int i=0; i<subString2.length; i++){
            subString2[i] = subStrings[i+1];
        }
        for(String str : subString2){
            if(str.contains("&")){
                String[] params = str.split("&");
                for(String str2 : params){
                    if(str2.contains("=")){
                        String[] subPar = str2.split("=");
                        if(subPar[0].equals("obj")){
                            //alert(subPar[0]);
                            System.out.print(subPar[0]+" ");
                            list.add(subPar[1]);
                        }
                        else System.out.print(subPar[0]+" ");          //alert(subPar[0]);
                    }
                    else{
                        if(!str2.isEmpty())System.out.print(str2+" ");  //alert(str2);
                    }
                }
            }
            else {
                if(str.contains("=")){
                    String[] subPar = str.split("=");
                    if(subPar[0].equals("obj")){
                        //alert(subPar[0]);
                        System.out.print(subPar[0]+" ");
                        list.add(subPar[1]);
                    }else System.out.print(subPar[0]+" ");              //alert(subPar[0]);
                }else{
                    if(!str.isEmpty())System.out.print(str+" ");        //alert(str);
                }
            }
        }
        System.out.println();
        for(Object obj : list){
            try{
                alert(Double.parseDouble((String) obj));

            }catch(NumberFormatException e){
                alert((String) obj);
            }
        }
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}