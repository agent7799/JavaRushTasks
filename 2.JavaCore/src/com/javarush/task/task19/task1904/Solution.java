package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws ParseException {

        String s = "Иванов Иван Иванович 31 12 1950";
        String[] strings = s.split(" ");
        Date birthDate = new SimpleDateFormat("ddMMyyyy").parse(strings[3] + (Integer.parseInt(strings[4])-1) + strings[5]);
        System.out.println(strings[1] + strings[2] + strings[0] + birthDate.toString());
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;


        PersonScannerAdapter(Scanner fileScanner) {                   //constructor
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {

                String s = fileScanner.nextLine();
                String[] strings = s.split(" ");
                Date birthDate = new SimpleDateFormat("ddMMyyyy").parse(strings[3] + strings[4] + strings[5]);
                return new Person(strings[1], strings[2], strings[0], birthDate);
        }

        @Override
        public void close () throws IOException {
            fileScanner.close();
        }
    }
}
