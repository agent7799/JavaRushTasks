package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона

+380501234567
+38(050)1234567
(050)1234567
0(501)234567
+38)050(1234567
+38(050)123-45-67
050ххх4567
050123456
(0)501234567

1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 1 пару скобок '(' и ')'
4) скобки (если они есть) внутри содержат четко 3 цифры
5) номер может содержать только цифры, '+', '(' и ')'
6) номер заканчивается на цифру

*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        boolean result = false;
        //если номер начинается с '+', он содержит 12 цифр до конца ($)
        String r1 = "^\\+(\\d[()]?){12}$";

        //если номер начинается с цифры или ("?" - необязательно) открывающей скобки, и он содержит 10 цифр
        String r2 = "^([()]?\\d){10}$";

        // может содержать: 1 пару скобок '(' и ')', скобки (если они есть) содержащие четко 3 цифры, обязательно цифры до конца
        String r3 = "^(\\+)?([()])?(\\(\\d{3}\\))?\\d+$";

        /*

        r1
        ^\\+            если номер начинается с '+'
        (\\d[()]?)     он содержит строго цифры и (необязательно)пару скобок
        {12}$"         и всего 12 раз(цифр) до конца ($)

        или
        r2
        ^([()]?\\d)     если номер может начинаться со скобок ("?" - необязательно) или с цифры
        {10}$           и он содержит 10 цифр до конца

        и
        r3
        ^(\\+)?             может начинаться с "+",
        (\\d+)?             содержать цифры больше одной,
        (\\(\\d{3}\\))?     скобки (если они есть) внутри содержат четко 3 цифры,
        \\d+$               цифры

        Решение:
        return (telNumber.matches("^\\+(\\d[()]?){12}$") || telNumber.matches("^([()]?\\d){10}$"))
                       && telNumber.matches("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$");
         */



        if (telNumber == null){
            return false;
        }

        if (
                (telNumber.matches("^\\+(\\d[()]?){12}$") || telNumber.matches("^([()]?\\d){10}$"))
                && telNumber.matches("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$"))
        {
            result =  true;
        }


        return result;
    }

    public static void main(String[] args) {

        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("(050)1234567"));
        System.out.println(checkTelNumber("0(501)234567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)123-45-67"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));


    }


}
