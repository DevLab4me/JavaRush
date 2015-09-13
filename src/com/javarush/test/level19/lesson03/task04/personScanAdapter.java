package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class personScanAdapter {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        PersonScannerAdapter (Scanner scanner) {
            this.scanner = scanner;
        }


        @Override
        public Person read() throws IOException
        {
            String line = this.scanner.nextLine();
            String [] splitLine = line.split(" ");

            Calendar calendar = new GregorianCalendar(Integer.parseInt(splitLine[5]), Integer.parseInt(splitLine[4])-1, Integer.parseInt(splitLine[3]));
            Date date = calendar.getTime();
            Person person = new Person(splitLine[1], splitLine[2], splitLine[0], date);
            return person;
        }

        @Override
        public void close() throws IOException
        {
           this.scanner.close();
        }
    }
}
