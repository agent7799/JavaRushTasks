package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

        //напишите тут ваш код
        public static HashSet<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> dateMap) {
            HashSet<LocalDateTime> dateSet = new HashSet<LocalDateTime>();
            for (var subDate : dateMap.entrySet()){
                List<LocalTime> subTimes = subDate.getValue();
                for (var localTime : subTimes){
                    dateSet.add(LocalDateTime.of(subDate.getKey(), localTime));
                }
            }
        return null;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}