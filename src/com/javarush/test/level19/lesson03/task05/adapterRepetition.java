package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class adapterRepetition {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            String res="";
            String country = this.customer.getCountryName();
            for (Map.Entry<String, String> pair : countries.entrySet()) {
               if (pair.getValue().equals(country))
                    res=pair.getKey();
            }
            return res;
        }

        @Override
        public String getCompany()
        {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String fullName = this.contact.getName();
            String [] initials = fullName.split(", ");
            return initials[1];
        }

        @Override
        public String getContactLastName()
        {
            String fullName = this.contact.getName();
            String [] initials = fullName.split(", ");
            return initials[0];
        }

        @Override
        public String getDialString()
        {
            String initialNum = this.contact.getPhoneNumber();
            String phoneNum = contact.getPhoneNumber().replaceAll("[()-]","");
            return "callto://" + phoneNum;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}