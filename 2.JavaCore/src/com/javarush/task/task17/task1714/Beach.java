package com.javarush.task.task17.task1714;

/* 
Comparable
*/


public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach one = new Beach("one", 10, 5);
        Beach two = new Beach("two", 10, 5);
        System.out.println(one.compareTo(two));
    }

    @Override
    public synchronized int compareTo(Beach o) {
        int current = 0;
        int other = 0;
        if (distance - o.getDistance() < 0){
            current++;
        } else if (distance - o.getDistance() > 0){
            other++;
        }
        if (quality - o.getQuality() > 0){
            current++;
        } else if (quality - o.getQuality() < 0){
            other++;
        }
        if (current > other) {
            return 1;
        } else if (current < other) {
            return -1;
        } else {
            return 0;
        }

    }
}
