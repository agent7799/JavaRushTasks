package com.javarush.task.pro.task17.task1708;

/*
Минимальное и максимальное
*/

  public class MinMaxUtil {
        public static int min(int a, int b) {
           int result = Math.min(a,b);
            return result;
        }
        public static int min(int a, int b, int c) {
            int temp = Math.min(a, b);
            return Math.min(temp, c);
        }
        public static int min(int a, int b, int c, int d) {
            int tempA = Math.min(a, b);
            int tempB = Math.min(c, d);
            return Math.min(tempA, tempB);
        }
        public static int min(int a, int b, int c, int d, int e) {
            int tempA = Math.min(a, b);
            int tempB = Math.min(c, d);
            int tempC = Math.min(tempA, tempB);
            return Math.min(tempC, e);
        }


        public static int max(int a, int b) {
            int result = Math.max(a,b);
            return result;
        }
        public static int max(int a, int b, int c) {
            int temp = Math.max(a, b);
            return Math.max(temp, c);
        }
        public static int max(int a, int b, int c, int d) {
            int tempA = Math.max(a, b);
            int tempB = Math.max(c, d);
            return Math.max(tempA, tempB);
        }
        public static int max(int a, int b, int c, int d, int e) {
            int tempA = Math.max(a, b);
            int tempB = Math.max(c, d);
            int tempC = Math.max(tempA, tempB);
            return Math.max(tempC, e);
        }

        //напишите тут ваш код
    }