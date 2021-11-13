package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static DateFormat dateFormatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static DateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    
    public static void main(String[] args) throws ParseException {
        if (args == null || args.length < 1) {
            throw new RuntimeException();
        }
        
        //напишите тут ваш код
//        Person person;
        Date birthDate;


        switch (args[0]) {

            case ("-c"): {
                birthDate = dateFormatIn.parse(args[3]);
                if (args[2].equalsIgnoreCase("м")) {
                    allPeople.add(Person.createMale(args[1], birthDate));
                } else {
                    allPeople.add(Person.createFemale(args[1], dateFormatIn.parse(args[3])));
                }
                System.out.println(allPeople.size()-1);
                break;
            }
            case ("-r"): {
                int i = Integer.parseInt(args[1]);
                try {
                    String sex = allPeople.get(i).getSex() == Sex.MALE ? "м" : "ж";
                    System.out.println(allPeople.get(i).getName() + " " + sex + " " + dateFormatOut.format(allPeople.get(i).getBirthDate()));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("No such index: " + i);
                    break;
                }
                break;
            }
            case ("-u"): {
                int i = Integer.parseInt(args[1]);
                allPeople.get(i).setName(args[2]);
                Sex sex = (args[3]).equals("м") ? Sex.MALE : Sex.FEMALE;
                allPeople.get(i).setSex(sex);
                allPeople.get(i).setBirthDate(dateFormatIn.parse(args[4]));
                break;
            }
            case ("-d"): {
                int i = Integer.parseInt(args[1]);
                allPeople.get(i).setBirthDate(null);
                allPeople.get(i).setName(null);
                allPeople.get(i).setSex(null);
                break;
            }
            default: {

            }


//        for (int i = 0; i < args.length ; i++){
//            System.out.println("args[" + i + "] = " + args[i]);
//        }
//
//
//        for (int i = 0; i < allPeople.size() ; i++){
//            System.out.println(allPeople.get(i));
//            }


        }
    }
}
