package com.javarush.task.task23.task2310;

/* 
Напряги извилины!
*/

public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    /*
    Когда у тебя стоит public, то анонимный класс, который создается в sout(), наследует метод getName(),
    и при вызове этот метод возвращает значение поля name из этого анонимного класса.
    А если ты меняешь на private, то анонимный класс его не наследует, и при вызове getName() будет срабатывать
    "родительский" метод (из самого Solution, а не из его анонимного наследника), а у родителя другое значение
    поля name - поэтому и вывод будет другой.
     */

    public String getName() {       //private -> public
        return name;
    }

    private void sout() {
        new Solution("The Darkside Hacker") {

            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("Риша").sout();
    }
}
