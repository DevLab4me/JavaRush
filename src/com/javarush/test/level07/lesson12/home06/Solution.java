package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static final boolean MALE = true;
    public static final boolean FEMALE = false;

    public static void main(String[] args)
    {
        Human[] family = new Human[9];

        family[0] = new Human("Борим Моисеевич",        MALE,   69, null,       null);
        family[1] = new Human("Иосиф Виссарионович",    MALE,   92, null,       null);
        family[2] = new Human("Клара Захаровна",        FEMALE, 58, null,       null);
        family[3] = new Human("Изольда Тихоновна",      FEMALE, 79, null,       null);
        family[4] = new Human("Alexandr Ivanov",        MALE,   40, family[1],  family[3]);
        family[5] = new Human("Veronika Ivanova",       FEMALE, 36, family[0],  family[2]);
        family[6] = new Human("Настя",                  FEMALE, 5,  family[4],  family[5]);
        family[7] = new Human("Вовочка",                MALE,   10, family[4],  family[5]);
        family[8] = new Human("Татьяна",                FEMALE, 16, family[4],  family[5]);

        for (Human x : family)
        {
            System.out.println(x);
        }//Написать тут ваш код
    }

    public static class Human
    {
        private String  name;
        private boolean sex;
        private int     age;
        private Human   father;
        private Human   mother;

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }//Написать тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
