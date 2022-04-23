package com.javarush.task.task23.task2312;

public class SnakeSection {
    private int x;
    private int y;

    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        int result = 31*x + y;
        return result;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  //сравниваем ссылки
        if (o == null || getClass() != o.getClass()) return false; //сравниваем идентичность класса

        SnakeSection s = (SnakeSection) o;

        if (x != s.x) return false; //сравниваем координаты x
        return y == s.y;            //сравниваем координаты y
    }


}
