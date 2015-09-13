package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name;
        private String surname;
        private boolean sex;
        private double age;
        private Date DateOfBirth;
        private int height;

        public Human(){
        }
        public Human(double age){
            this.age = age;
        }
        public Human(Date DateOfBirth){
            this.DateOfBirth = DateOfBirth;
        }
        public Human(String name){
        this.name = name;
        }
        public Human(String name, String surname){
            this.name = name;
            this.surname = surname;
        }
        public Human(boolean sex){
            this.sex = sex;
        }
        public Human(int height){
            this.height = height;
        }
        public Human(String name, String surname, int age, boolean sex){
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
        }
        public Human(String name, String surname, int age, boolean sex, Date DateOfBirth){
            this(name, surname, age, sex);
            this.DateOfBirth = DateOfBirth;
        }
        public Human(String name, String surname, int age, boolean sex, Date DateOfBirth, int height){
            this(name, surname, age, sex, DateOfBirth);
            this.height = height;
        }//напишите тут ваши переменные и конструкторы
    }
}
