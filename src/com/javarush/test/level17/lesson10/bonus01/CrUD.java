package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class CrUD {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception
    {
        if (args.length == 2) {
            addPerson(args[0], Integer.parseInt(args[1]));
        }
        if (args.length == 4){
            addPerson(args[0], args[1], args[2], args[3]);
        }
        if (args.length == 5){
            addPerson(args[0], Integer.parseInt(args[1]), args[2], args[3], args[4]);
        }
    }
    public static void addPerson (String c, String name, String sex, String bd){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(bd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Person person;
        if (c.equals("-c")) {
            if (sex.equals("м"))
            {
                person = Person.createMale(name, date);
            } else if (sex.equals("ж"))
            {
                person = Person.createFemale(name, date);
            } else {
                return;
            }
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
    }
    public static void addPerson (String u, int id, String name, String sex, String bd){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(bd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (u.equals("-u")){
            if (allPeople.size() > id){
                if (sex.equals("м"))
                    allPeople.set(id, Person.createMale(name, date));
                if (sex.equals("ж"))
                    allPeople.set(id, Person.createFemale(name, date));

            }

        }
    }
    public static void addPerson (String s, int id) {
        if (s.equals("-d")){
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDay(null);
        }


        if (s.equals("-i")){
            String se = "";
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            if(allPeople.get(id).getSex().equals(Sex.FEMALE))
                se = "ж";
            if (allPeople.get(id).getSex().equals(Sex.MALE))
                se = "м";
            System.out.println(allPeople.get(id).getName() + " " + se + " " + format.format(allPeople.get(id).getBirthDay().getTime()));
        }
    }
}