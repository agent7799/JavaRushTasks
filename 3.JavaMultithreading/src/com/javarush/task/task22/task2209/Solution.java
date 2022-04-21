package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов

c:\java\test.txt

*/

public class Solution {
    public static void main(String[] args) {
        //String fileName = "C:\\java\\test.txt";;
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {
            while (fileReader.ready()) {
                list.add(fileReader.readLine());
            }
        } catch (IOException ignored) {
        }

        List<String> resultList = new ArrayList<>();
        for (String line : list) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                resultList.add(tokenizer.nextToken());
            }
        }

        StringBuilder result = getLine(getWords(resultList));
        System.out.println(result.toString());
        //создаем его, прочитав данные из файла методом getWords
    }

    private static String[] getWords(List<String> list) {
        //полученный ArrayList слов из файла преобразуем в массив строк для передачи в метод getLine
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
//        for (String s : array) {
//            System.out.println("getWords: " + s);
//        }
        return array;
    }

    private static boolean isTheSameChars(String firstWord, String secondWord) {
        if (firstWord.endsWith(" ")) {
            firstWord = firstWord.substring(0, firstWord.length() - 1);
        }
        return firstWord.isEmpty() || (secondWord != null &&
                Character.toUpperCase(firstWord.charAt(firstWord.length() - 1)) == Character.toUpperCase(secondWord.charAt(0)));
    }

    private static <T> T getLastElement(List<? extends T> list) {
        return list.get(list.size() - 1);
    }


    public static StringBuilder getLine(String... words) {
//        for (String s : words) {
//            System.out.println("getLine words: " + s);
//        }
        StringBuilder builder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        //ArrayList<String> stringList = new ArrayList<>();
        //для каждого слова из массива слов, полученных из файла
        for (int i = 0; i < words.length; i++) {
            list.add(i);
            if (findSolutions(list, words)) {
                //метод возвращает true,то добавляем слова в srtringBuilder
                for (Integer integer : list) {
                    builder.append(words[integer]);
                    builder.append(" ");
                }
                System.out.println("builder: " + builder.toString());
                return builder;
            }
            list.remove(Integer.valueOf(i));
        }

        return builder;
    }

    private static boolean findSolutions(List<Integer> list, String... words) {
        if (list.size() == words.length) {
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            if (isValid(list, words[i], words)) {
                list.add(i);
                if (findSolutions(list, words)) {
                    return true;
                }
                list.remove(Integer.valueOf(i));
            }
        }
        return false;
    }
    // возвращаем последний элемент списка - аргумента
    private static boolean isValid(List<Integer> list, String word, String... words) {
        for (Integer integer : list) {
            if (words[integer].equals(word)) {
                return false;
            }
        }
        return isTheSameChars(words[getLastElement(list)], word);
    }

//    private static void wordsSort(ArrayList<String> stringArrayList) {
//        for (int i = 0; i < stringArrayList.size(); i++) {
//            String s = stringArrayList.get(i);
//            String lastChar = s.substring(s.length() - 1);
//            for (int j = i + 1; j < stringArrayList.size(); j++) {
//                String firstChar = stringArrayList.get(j).substring(0, 1);
//                if (lastChar.equalsIgnoreCase(firstChar)) {
//                    String temp = stringArrayList.get(i + 1);
//                    stringArrayList.set(i + 1, stringArrayList.get(j));
//                    stringArrayList.set(j, temp);
//                    break;
//                }
//            }
//
//        }
//    }
}
