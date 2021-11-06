package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/*
Лишь бы не в понедельник:)
*/

public class Solution {

    static Date birthDate = new Date(77, 7, 7);;

        public static void main(String[] args) {
            System.out.println(getDayOfWeek(birthDate));
        }
        static String getDayOfWeek(Date date) {
            //напишите тут ваш код
            int wd = date.getDay();
            String weekDay = "";
             switch (wd) {
                 case 0:
                     return  "Воскресенье";
                 case 1 :
                     return "Понедельник";
                 case (2) :
                    return "Вторник";
                 case (3):
                    return "Среда";
                 case (4) :
                    return  "Четверг";
                 case (5) :
                     return "Пятница";
                 case (6):
                    return "суббота";
                 default:
                     return weekDay;

             }

        }

}