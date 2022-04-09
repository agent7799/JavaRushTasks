package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object n) {
        if (n == this) {
            return true;
        }

        if (!(n instanceof Solution)) {
            return false;
        }
        Solution solution = (Solution) n;

        if (n.hashCode() != this.hashCode()) {
            return false;
        }
//  Метод equals должен возвращать true в случае, если поля first и last равны у переданного объекта и
//  текущего(не забудь что они могут быть равны null):
        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        return last != null ? last.equals(solution.last) : solution.last == null;

}

    @Override
    public int hashCode() {
        return 31 * (first != null ? first.hashCode() : 0) + (last != null ? last.hashCode() : 0);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
