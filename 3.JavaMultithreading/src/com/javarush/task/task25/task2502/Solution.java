package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            String[] wheels = loadWheelNamesFromDB();
            if (wheels.length != 4) {
                throw new NoSuchElementException();
            }
            this.wheels =new ArrayList<>();
            for (String w : wheels) {
                this.wheels.add(Wheel.valueOf(w));
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car();
    }
}
