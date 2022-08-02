package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);

    }

    static String balancedTernary(int n){
        StringBuilder sb = new StringBuilder(n + " = ");
        String output = "";
        int grade = 0;
        int res;
        while (n > 0)
        {
            int rem = n % 3;
            n = n / 3;
            if (rem == 2)
            {
                rem = -1;
                n++;
            }
            res = Math.abs((int) Math.pow(3, grade)*rem);
            System.out.println("res = " + res);
            System.out.println("rem = " + rem);
//            output = (rem == 0 ? '0' :
//                    (rem == 1) ? '1' : 'Z') + output;
            output = (rem == 0 ? "" :
                     (rem == 1) ? " + " + res : " - " + res);

            //System.out.println(output);
            sb.append(output);
            grade++;
        }
        System.out.println(sb);
        return output;
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        StringBuilder sb = new StringBuilder(number + " =");
        String output = "";
        int grade = 0;
        int res;
        while (number > 0)
        {
            int rem = number % 3;
            number = number / 3;
            if (rem == 2)
            {
                rem = -1;
                number++;
            }
            res = Math.abs((int) Math.pow(3, grade)*rem);
            //System.out.println("res = " + res);
            // System.out.println("rem = " + rem);
//            output = (rem == 0 ? '0' :
//                    (rem == 1) ? '1' : 'Z') + output;
            output = (rem == 0 ? "" :
                    (rem == 1) ? " + " + res : " - " + res);

            //System.out.println(output);
            sb.append(output);
            grade++;
        }
        System.out.println(sb);
    }
}