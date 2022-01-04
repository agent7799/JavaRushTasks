package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

        //File file = new File(args[0]);
        //String file = args[0];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String s;
            String name;
            Date birthDate;
            DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");

            while (reader.ready()){
                s = reader.readLine();
                name = s.replaceAll(" \\d.*+\\d*+\\d*", "");
                s = s.replaceAll("\\W+ ", "");
                birthDate = dateFormat.parse(s);
                PEOPLE.add(new Person(name, birthDate));
            }
            reader.close();

            for (Person p : PEOPLE){
                System.out.println(p.getName() + " " + p.getBirthDate());
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
