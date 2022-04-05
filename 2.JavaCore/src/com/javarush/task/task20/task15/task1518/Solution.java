package com.javarush.task.task20.task15.task1518;

/* 
Статики и котики
*/

public class Solution {
    public static Cat cat;

    public static void main(String[] args) {

    }

    public static class Cat {
        public String name;
    }

    static {
        Solution.cat = new Cat();
        cat.name = "Tom";
        System.out.println(cat.name);
    }
}
