package com.javarush.task.pro.task17.task1704;

import java.util.ArrayList;

/*
Космическая одиссея ч.2
*/

public class Solution {
    public static ArrayList<Astronaut> astronauts = new ArrayList<>();

    public static void main(String[] args) {
        createCrew();
        printCrewInfo();
        runWorkingProcess();
    }

     public static void runWorkingProcess() {
            //напишите тут ваш код
            for (Astronaut crewMember : astronauts){

                if (crewMember instanceof Human){
                     pilot((Human) crewMember);         // объект crewmember типа Astronaut приводим к типу Human
                }
                if (crewMember instanceof Dog){
                    createDirection((Dog) crewMember);
                }
                if (crewMember instanceof Cat){
                    research((Cat) crewMember);
                }
            }
        }

    public static void pilot(Human human){
        System.out.println("Член экипажа " + human.getInfo() + " пилотирует корабль.");
    }

    public static void createDirection(Dog dog){
        System.out.println("Член экипажа " + dog.getInfo() + " занимается созданием навигационного маршрута.");
    }

    public static void research(Cat cat){
        System.out.println("Член экипажа " + cat.getInfo() + " исследует ближайшие планеты.");
    }

    public static void createCrew() {
        astronauts.add(new Human());
        astronauts.add(new Human());
        astronauts.add(new Dog());
        astronauts.add(new Cat());
    }

    public static void printCrewInfo() {
        System.out.println("На борт погружены члены экипажа: ");
        for (Astronaut astronaut : astronauts) {
            System.out.println(astronaut.getInfo());
        }
    }
}