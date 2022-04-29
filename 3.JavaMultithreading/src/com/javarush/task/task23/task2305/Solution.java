package com.javarush.task.task23.task2305;

/* 
Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Requirements:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];



    public class InnerClass {
    }

        public static Solution[] getTwoSolutions() {
               Solution[] result = new Solution[2];     //создаем массив из объектов Solution размером 2
            
                for (int i = 0 ; i < result.length; i++) {      //для каждого элемента массива объектов Solution
                    result[i] = new Solution();                 // инициализируем объект Solution
                    for (int j = 0; j < result[i].innerClasses.length; j++) {
                        /** для каждого элемента массива innerClasses, который является (статическим) полем
                         * в каждом объекте Solution
                         * производим инициализацию элемента массива innerClasses через ссылку на объект Solution,
                         * т.к. к статическому полю класса обертки innnerClasses прямо без объекта обертки мы
                         * обратиться не можем
                         */
                        result[i].innerClasses[j] = result[i].new InnerClass();
                    }
                }


            return result;
        }

    public static void main(String[] args) {

    }
}
