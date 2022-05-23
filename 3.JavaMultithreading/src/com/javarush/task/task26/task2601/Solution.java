package com.javarush.task.task26.task2601;

/*
Почитать в инете про медиану выборки
*/

import java.util.*;

public class Solution {

    public static void main(String[] args) {

       Integer[] ints = {13, 8, 15, 5, 17, 16};
        sort(ints);

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here

        int arrayLength = array.length;
        double median = 0.0;

        Arrays.sort(array);

        if (arrayLength%2 == 0){
            median = (array[arrayLength/2-1] + array[arrayLength/2])/2;
        }else{
            median = array[arrayLength/2];
        }
        //System.out.println("median " + median);



        Map<Integer, Double> map = new TreeMap<>();

        for (int i = 0; i < arrayLength; i++) {
            double deviation = Math.abs(array[i] - median);
            map.put(i, deviation);
        }

        ArrayList<Double> mediansArray = new ArrayList<>(map.values());
        Collections.sort(mediansArray);

        ArrayList<Integer> res = new ArrayList<>();

        for (Double aDouble : mediansArray) {
            for (Map.Entry<Integer, Double> entry : map.entrySet()) {
               if (aDouble == entry.getValue()){
                    res.add(array[entry.getKey()]);
               }
            }
        }

        Integer[] result = new Integer[arrayLength];

        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
            //System.out.println(result[i]);
        }



        return result;
    }
}
