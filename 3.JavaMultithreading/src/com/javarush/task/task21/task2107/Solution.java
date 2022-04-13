package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(users, solution.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }







    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution o = (Solution) super.clone();                      //создаем новый объект Solution
        Map<String, User> newUsers = new LinkedHashMap();           // создаем новую мапу
        for (String key : o.users.keySet()){                        // перебираем и в новую мапу клонируем каждый
            User user = o.users.get(key);                           //user в новую мапу
            newUsers.put(key, (User) user.clone());                 //
        }
        o.users = newUsers;                                         //присваиваем мапе клонированного объекта получившуюся мапу
        return o;                                                   // возвращаем новый объект
    }


}
