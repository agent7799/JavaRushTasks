package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/

public class Solution implements Serializable{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }

    public static class A {

        protected String nameA = "A1";

        public A(){
        }
        
        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {

        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }

        /** Так как класс А не сериализируется, то при дессириализации он будет заново создаваться через класс В
         и поле nameA будет инициализировано так как указано в классе А. Что бы это исправить, надо :
         1) в метод writeObject к стандартной записи объекта добавить запись nameA
         2) в метод readObject к стандартному чтению объекта надо дополнительно инициализировать nameA ранее
         записанным значением.
        */

        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.defaultWriteObject();
            oos.writeObject(nameA);
        }
        
        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            ois.defaultReadObject();
            nameA = (String) ois.readObject();
        }
    }
}
