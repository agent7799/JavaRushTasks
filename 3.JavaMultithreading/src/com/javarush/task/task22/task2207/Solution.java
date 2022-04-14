package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;


/* 
Обращенные слова

пример файла:

рот тор торт о
о тот тот тот
комок потоп комок потоп

*/


//мое решение
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String fileName = scanner.nextLine();
        String fileName = "C:\\java\\test.txt";
        ArrayList<String> words = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
                String[] tempStrings = null;
                while (reader.ready()){
                     tempStrings = reader.readLine().split(" ");
                    Collections.addAll(words, tempStrings);
                }
                System.out.println(words);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {

                if(words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString())){
                    Pair p = new Pair();
                    p.first = words.get(j);
                    p.second = words.get(i);
//                    if (!result.contains(p)) {
                        result.add(p);
//                    }
                    words.set(i, "");
                    words.set(j, "");
                }

            }
        }

        for (Pair map : result) {
            System.out.println(map.first + " " + map.second);
        }

    }


//решение валидатора

//    public static void main(String[] args) throws Exception {
//        String fileName = "C:\\java\\test.txt";
//        List<String> words = new ArrayList<>();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        //BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
//        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
//        bufferedReader.close();
//        while (fileReader.ready()) {
//            words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
//        }
//        fileReader.close();
//
//        for (int i = 0; i < words.size(); i++) {
//            for (int j = 0; j < words.size(); ) {
//                if (i >= words.size()) {
//                    break;
//                }
//                if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i) {
//                    Pair pair = new Pair();
//                    pair.first = words.get(j);
//                    pair.second = words.get(i);
//                    result.add(pair);
//                    words.remove(j);
//                    words.remove(i);
//                    j = 0;
//                } else
//                    j++;
//            }
//        }
//
//        for (Pair map : result) {
//            System.out.println(map.first + " " + map.second);
//        }
//    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
