package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

import javax.swing.*;

public class Solution {

        public int intVar;
        public double doubleVar;
        public Double DoubleVar;
        public boolean booleanVar;
        public Object ObjectVar;
        public Exception ExceptionVar;
        public String StringVar;


    public static void main(String[] args) {

        Solution solution = new Solution();
        //Для обращения  к нестатическому полю необходимо создать класс
        // и обращаться к нему через имя Объекта!

        System.out.println(solution.intVar);
        System.out.println(solution.doubleVar);
        System.out.println(solution.DoubleVar);
        System.out.println(solution.booleanVar);
        System.out.println(solution.ObjectVar);
        System.out.println(solution.ExceptionVar);
        System.out.println(solution.StringVar);
    }


}
