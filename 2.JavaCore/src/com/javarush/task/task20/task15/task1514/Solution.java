package com.javarush.task.task20.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.1, "111");
        labels.put(1.2, "222");
        labels.put(1.3, "333");
        labels.put(1.4, "444");
        labels.put(1.5, "555");
    }

    public static void main(String[] args) {

        System.out.println(labels);
    }
}
