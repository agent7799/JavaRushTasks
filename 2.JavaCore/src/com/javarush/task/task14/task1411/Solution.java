package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key;
       // while (Stream.of("user", "loser", "coder", "proger").anyMatch(reader.readLine()::equalsIgnoreCase))
        do { key = reader.readLine();
            switch (key) {
                case "user": {
                    person = new Person.User();
                    doWork(person); //вызываем doWork
                    break;
                }
                case "coder": {
                    person = new Person.Coder();
                    doWork(person); //вызываем doWork
                    break;
                }
                case "loser": {
                    person = new Person.Loser();
                    doWork(person); //вызываем doWork
                    break;
                }
                case "proger": {
                    person = new Person.Proger();
                    doWork(person); //вызываем doWork
                    break;
                }

            }

        } //while (Stream.of("user", "loser", "coder", "proger").noneMatch(reader.readLine()::equalsIgnoreCase));
            while (key.equalsIgnoreCase("user") ||
                key.equalsIgnoreCase("loser") ||
                key.equalsIgnoreCase("coder") ||
                key.equalsIgnoreCase("proger"));
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User ){
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }

}
