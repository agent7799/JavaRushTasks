package task_2025_alternateSolutions;

import java.util.*;

/**
 * memory 13806
 *
 * time = 5
 *
 * Я решил это... в сумме наверное 20 часов просидел за этой задачей... жесть
 *
 * Кароче, так как я нигде для себя не нашел нормальных пояснений, и вам их не дам)) но дам подсказки , по крайней мере
 * по моему "стилю" решения этой задачи:
 *
 * 1.) первой строкой проверка что N < 0 вовращаем пустой массив - иначе валидатор не пропустит, даже если он потом всё
 * равно нормально пустым возвращается.
 *
 * 2.) Пример выше в большей степени не актуален, но..
 *
 * 3.) Блок 1 (там подписано)  у меня верный, что радует, я в него ещё добавил чтобы мне на лету записывалась реальная
 * длина числа в моём массиве без лидирующих нулей.
 *
 * 4.) Блок 2 - если его заключить в условие чтобы проверка была , когда реальная длина моего массива (из пункта 3) была
 * равна длине числа N - то первые два блока без лишнего кода будут выполнятся меньше чем за секунду для Лонг Макс валуе
 * 5)блоки 3, 4, 5 я удалил, они не верные.
 *
 * 6)Стринг ну очень сильно тормозит цикл, так что я его использовал только 2 раза, в блоке 2 и чуть позже чтобы разбит
 * ь число на массив Чар.
 *
 * 7)Когда вы будете вычислять сумму степеней на больших числах (ближе к 19 знакам) - то эта сумма степеней не влезет в
 * лонг - но БигИнтеджер всё равно не используйте, он увеличит на минуту время прохода, лучше проверяйте что лонг больше
 * нуля постоянно (когда примитив переполняется, он начинает со своей нижней отметки -99...)
 *
 * 8)Очень большой косяк моего метода (исходя из блока 1) что этот метод не учитывает нули , из-за чего 37 и 370 для
 * моего перебора равны, а значит я возьму только 37 и возведу в степень 2, а 370 в степень 3 уже не возведу (это
 * проблема опубликованного кода) - я это решил возводя все цифры из блока 1 во все степени от минимальной (число 37
 * степень 2) до максимальной (число Лонг Макс валуе), при этом я каждый результат ещё раз проверяю что он Армстронг,
 * так как если его опять возвести в степень самого себя, то он выдаст ещё раз сам себя.
 *
 * 9)МатхПуф МЕДЛЕННЕЕ чем возведение в степень в цикле через *= ..
 *
 * 10)лимит символов сообщени
 */


public class Solution2025 {


    /*
    Алгоритмы-числа
    */

        public static long[] getNumbers(long N) {
            long lastLong = 0;
            int[] numbers = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//тут массив из 19 знаков, с помощью которого я буду перебирать весь лонг
            ArrayList<Long> longArrayList = new ArrayList<>();
            N = 10_000;
//        N = Long.MAX_VALUE;

            int n = 0;
            long numLong = 0;
            int lenght = numbers.length-1;

            while (lastLong<N){
                //1--В этом блоке собственно проход всех цифр с условием что "142 и 124" равны-(https://acmp.ru/article.asp?id_text=198)-
                n++;
                numbers[lenght] = n;
                if(n == 10){// тут думаю можно сделать и в один цикл, но пока не понял как...
                    for (int i = lenght; i >= 0; i--) {//тут измению значения в ячейках массива с его конца
                        if(numbers[i]>=10){
                            if(i-1>=0){
                                numbers[i-1]++;
                            }
                        }
                    }
                    for (int i = 0; i < lenght+1; i++) {
                        //если значение в ячейки доходит до 10 то увеличиваю следующую ячейку а текущая не должна быть меньше следующей.
                        if(numbers[i]>=10){
                            if(i-1>=0){
                                numbers[i] = numbers[i-1];
                            }
                        }
                    }
                    n = numbers[lenght];
                }
                //-------------------------------------------------------------------------


                //2----------------тут я прикидываю а не пора ли закончить перебор----------
                String numString = "";
                for (int i = 0; i < numbers.length; i++) {
                    numString +=numbers[i];
                }
                try {
                    numLong = Long.parseLong(numString);
                }catch (Exception e){
                    break;
                }
                lastLong = numLong;
                //-------------------------------------------------------------------------



                //3--------------------------Тут получаю сумму степеней всех цифр числа------
                long summ = 0;
                for (int i1 = 0; i1 < numbers.length; i1++) {
                    summ += (Math.pow(numbers[i1],String.valueOf(numLong).length()));
                }
                //-------------------------------------------------------------------------

                //4-----------Тут я хитро проверяю что сумма степеней от числа армстронга-------
                int[] resNumbers = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                ArrayList<Integer> integerArrayList = new ArrayList<>();
                for (int i = 0; i < String.valueOf(summ).length(); i++) {
                    integerArrayList.add(Integer.parseInt(String.valueOf(summ).split("")[i]));
                }
                integerArrayList.sort(Collections.reverseOrder());
                for (int i = 0; i < integerArrayList.size(); i++) {
                    resNumbers[(resNumbers.length-1)-i] = integerArrayList.get(i);
                }
                if(Arrays.equals(resNumbers,numbers) ){
                    longArrayList.add(summ);
//                System.out.println(" equals Прокатило");
                }
//            System.out.println(Arrays.toString(resNumbers));
                System.out.println("RESULT= "+Arrays.toString(resNumbers)+"\n"+"ORIGGN= "+Arrays.toString(numbers)+"\n");
                //-------------------------------------------------------------------------

                //5------------------не помню зачем но пусть будет-----------------------------
                if(numbers[0]==10){
                    break;
                }
                //-------------------------------------------------------------------------

            }

            long[] result = new long[longArrayList.size()];
            for (int i = 0; i < longArrayList.size(); i++) {
                result[i] = longArrayList.get(i);
            }

            return result;
        }

        public static void main(String[] args) {
            long a = System.currentTimeMillis();
            System.out.println(Arrays.toString(getNumbers(1000)));
            long b = System.currentTimeMillis();
            System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
            System.out.println("time = " + (b - a) / 1000);

//         a = System.currentTimeMillis();
//        System.out.println(Arrays.toString(getNumbers(1000000)));
//         b = System.currentTimeMillis();
//        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
//        System.out.println("time = " + (b - a) / 1000);

        }
    }

