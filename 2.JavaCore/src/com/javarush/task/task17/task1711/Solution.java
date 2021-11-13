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

        if (args == null || args.length < 1) {
            //System.out.println("Error! Check arguments!");
            throw new RuntimeException();
        }


        switch (args[0]) {
            case ("-c"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
//                    addPerson(args[i+1], args[i+2], args[i+3]);
//                    System.out.println(allPeople.get(i));
                        String name = args[i];
                        Date birthDate = dateFormatIn.parse(args[i + 2]);
                        String sex = args[i + 1];
                        Person person = sex.equals("м") ? Person.createMale(name, birthDate) : Person.createFemale(name, birthDate);
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                    break;
                }

            case ("-u"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
//                    updatePerson(args[i+1], args[i+2], args[i+3], args[4]);
//                    System.out.println(allPeople.get(i));
                        int id = Integer.parseInt(args[i]);
                        String name = args[i + 1];
                        String sex = args[i + 3];
                        Date birthDate = dateFormatIn.parse(args[i + 3]);
                        Person currentPerson = allPeople.get(id);
                        currentPerson.setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
                        currentPerson.setName(name);
                        currentPerson.setBirthDate(birthDate);
                    }
                }
            case ("-d"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        //deletePerson(i);
                        Person currentPerson = allPeople.get(Integer.parseInt(args[i + 1]));
                        currentPerson.setBirthDate(null);
                        currentPerson.setName(null);
                        currentPerson.setSex(null);

                    }
                }
            case ("-i"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
//                    printPerson(i);

                        int id = Integer.parseInt(args[i + 1]);
                        Person currentPerson = allPeople.get(id);
                        String name = currentPerson.getName();
                        String sex = currentPerson.getSex() == Sex.MALE ? "м" : "ж";
                        String birthDate = dateFormatOut.format(currentPerson.getBirthDate());
                        System.out.println(name + sex + birthDate);
                    }
                }

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

