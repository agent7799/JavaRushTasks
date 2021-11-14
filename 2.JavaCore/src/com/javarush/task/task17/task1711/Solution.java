package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {


    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static DateFormat dateFormatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static DateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        Date birthDate;
        Person person;
        switch (args[0]) {
            case ("-c"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
//                    addPerson(args[i+1], args[i+2], args[i+3]);
//                    System.out.println(allPeople.get(i));
                        String name = args[i];
                        birthDate = dateFormatIn.parse(args[i + 2]);
                        String sex = args[i + 1];
                        person = sex.equals("м") ? Person.createMale(name, birthDate) : Person.createFemale(name, birthDate);
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                    break;
                }

            case ("-u"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {

                        int id = Integer.parseInt(args[i]);
                        String name = args[i + 1];
                        String sex = args[i + 2];
                        birthDate = dateFormatIn.parse(args[i + 3]);
                        person = allPeople.get(id);
                        person.setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
                        person.setName(name);
                        person.setBirthDate(birthDate);
                    }
                    break;
                }
            case ("-d"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        //deletePerson(i);
                        //person = allPeople.get(Integer.parseInt(args[i]));
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                    }
                    break;
                }
            case ("-i"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
//                    printPerson(i);

                        int id = Integer.parseInt(args[i]);
                        person = allPeople.get(id);
                        String name = person.getName();
                        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
                        String bDate = dateFormatOut.format(person.getBirthDate());
                        System.out.println(name + " " + sex + " " + bDate);
                    }
                }
            break;
        }
    }
}

//
//
//        //напишите тут ваш код
//
//
//        private static Sex getSexFromString (String s){
//            return s.equals("м") ? Sex.MALE : Sex.FEMALE;
//        }
//
//        private static void addPerson (String name, String sex, String birthDate) throws ParseException {
//            if (getSexFromString(sex) == Sex.MALE) {
//                allPeople.add(Person.createMale(name, dateFormatIn.parse(birthDate)));
//            } else if (getSexFromString(sex) == Sex.FEMALE) {
//                allPeople.add(Person.createFemale(name, dateFormatIn.parse(birthDate)));
//            }
//            System.out.println(allPeople.size() - 1);
//        }
//
//
//        private static void deletePerson ( int id){
//            Person currentPerson = allPeople.get(id);
//            currentPerson.setBirthDate(null);
//            currentPerson.setName(null);
//            currentPerson.setSex(null);
//        }

//        private static void updatePerson (String id, String name, String sexString, String birthDate) throws
//        ParseException {
//            int i = Integer.parseInt(id);
//            Person currentPerson = allPeople.get(i);
//            Sex sex = getSexFromString(sexString);
//            currentPerson.setName(name);
//            currentPerson.setSex(sex);
//            currentPerson.setBirthDate(dateFormatIn.parse(birthDate));
//        }

//        private static void printPerson ( int id){
//            Person currentPerson = allPeople.get(id);
//            System.out.println(currentPerson.getName() +
//                    " " + currentPerson.getSex() +
//                    " " + dateFormatOut.format(currentPerson.getBirthDate()));
//        }

