package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    abstract void draw(Canvas canvas);

    abstract void move();


    boolean intersects(BaseObject o){
        double distance = Math.sqrt(Math.pow((this.getX() - o.getX()), 2) + Math.pow((this.getY() - o.getY()), 2));
        return (distance <= Math.max(this.getRadius(), o.getRadius()));

    }

}