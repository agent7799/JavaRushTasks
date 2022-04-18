package com.javarush.task.task22.task2208;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

/* 
Формируем WHERE
*/

public class Solution {


    public static void main(String[] args) {
        Map<String , String > map = new HashMap<>();
//        map.put("name","Ivanov");
//        map.put("country","Ukraine");
//        map.put("city","Kiev");
//        map.put("age",null);
        map.put(null,null);


        System.out.println(getQuery(map));
    }





    public static String getQuery(Map<String, String> params) {
        StringBuilder sb;
        String result = "";
        sb = new StringBuilder(result);
        for (Map.Entry<String , String> p : params.entrySet()) {
           if (p.getValue() != null){
                sb.append(p.getKey()).append(" = \'").append(p.getValue()).append("\' and ");
            }
        }
        result = sb.toString();
        if (result.length() > 5) {
            result = result.substring(0, result.length()-5);
        }

        return result;
    }
}
