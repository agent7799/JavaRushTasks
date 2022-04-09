package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/

public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();

        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();

        System.out.println("methodModifiers " + Integer.toBinaryString(methodModifiers));  //1001
        System.out.println("classModifiers " + Integer.toString((classModifiers),2));   //0001

        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {

        if ((specificModifier & allModifiers) >0 ){
            System.out.println("toBinaryString " + Integer.toBinaryString(specificModifier & allModifiers));
            System.out.println("toString " + Integer.toString((specificModifier & allModifiers), 2));

            return true;
        } else {
            return false;
        }


    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }
        return null;
    }
}
