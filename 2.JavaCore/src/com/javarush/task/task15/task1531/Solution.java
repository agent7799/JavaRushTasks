package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        int input;

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            input = Integer.parseInt(reader.readLine());
            if (input <= 150){
                break;
            }
            reader.close();
        }

        if (input < 0) {
            System.out.println("0");
        }else {
            System.out.println(factorial(input));
        }
    }

    public static String factorial(int n) {
        //add your code here
        BigDecimal f = BigDecimal.valueOf(1);
        for (int i = 1 ; i <= n ; i++)
            f = f.multiply(BigDecimal.valueOf(i));

        return ("" + f);
    }
}
