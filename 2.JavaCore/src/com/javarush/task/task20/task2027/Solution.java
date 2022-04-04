package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
//                {'f', 'd', 'e', 'r', 'l', 'k'},
//                {'u', 's', 'a', 'm', 'e', 'o'},
//                {'l', 'n', 'g', 'r', 'o', 'v'},
//                {'m', 'l', 'p', 'r', 'r', 'h'},
//                {'p', 'o', 'e', 'e', 'j', 'j'}

                {'f', 'd', 'e', 'e', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'a', 'g', 'o', 'o', 'v'},
                {'m', 'm', 'p', 'h', 'r', 'h'},
//                {'m', 'e', 'm', 'a', 's', 'h'},
                {'h', 'o', 'm', 'e', 'p', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        StringBuilder stringBuilder = new StringBuilder();
        List<Word> wordList= new ArrayList<>();

        for (int w = 0; w < words.length; w++) {

            System.out.println("Looking for " + words[w]);
            System.out.println("rows y crossword.length " + crossword.length);
            System.out.println("columns x crossword[0].length " + crossword[0].length);


//           //строки - rows
//            for (int y = 0; y < crossword.length; y++) {
//                int columns = crossword[y].length;
//                for (int x = 0; x < columns; x++) {
//                    stringBuilder = stringBuilder.append((char) crossword[y][x]);
//                }
//                System.out.println(y + " row: " + stringBuilder);
//                //поиск в строке прямой
//                if (stringBuilder.toString().contains(words[w])) {
//                    Word tempWord = new Word(words[w]);
//                    tempWord.setStartPoint(stringBuilder.indexOf(words[w]), y);
//                    tempWord.setEndPoint(stringBuilder.indexOf(words[w]) + words[w].length()-1, y);
//                    wordList.add(tempWord);
//                    System.out.println(tempWord);
//                    tempWord = null;
//                }
//                //поиск в строке обратный
//                    if (stringBuilder.reverse().toString().contains(words[w])){
//                        Word tempWord = new Word(words[w]);
//                        tempWord.setStartPoint( columns -1  - stringBuilder.indexOf(words[w]), y);
//                        tempWord.setEndPoint( columns -1  - stringBuilder.indexOf(words[w]) - (words[w].length()-1), y);
//                        wordList.add(tempWord);
//                        System.out.println(tempWord);
//                        tempWord = null;
//                    }
//                stringBuilder.setLength(0);
//            }

            //столбцы - columns
//            for (int y = 0; y < crossword[0].length; y++) {
//                int rows = crossword.length;
//                for (int x = 0; x < crossword.length; x++) {
//                    stringBuilder = stringBuilder.append((char) crossword[x][y]);
//                }
//                System.out.println(y + " column: " + stringBuilder);
//                //поиск в столбце прямой
//                if (stringBuilder.toString().contains(words[w])) {
//                    Word tempWord = new Word(words[w]);
//                    tempWord.setStartPoint(y, stringBuilder.indexOf(words[w]));
//                    tempWord.setEndPoint(y, stringBuilder.indexOf(words[w]) + (words[w].length()-1));
//                    wordList.add(tempWord);
//                    System.out.println(tempWord);
//                    tempWord = null;
//                }
//                //поиск в столбце обратный
//                    if (stringBuilder.reverse().toString().contains(words[w])){
//                        Word tempWord = new Word(words[w]);
//                        tempWord.setStartPoint( y, rows - 1 - stringBuilder.indexOf(words[w]));
//                        tempWord.setEndPoint( y, rows - 1 - stringBuilder.indexOf(words[w])-  (words[w].length()-1));
//                        wordList.add(tempWord);
//                        System.out.println(tempWord);
//                        tempWord = null;
//                    }
//                stringBuilder.setLength(0);
//            }

            //диагонали
            int yMax = crossword.length;
            System.out.println(yMax);
            int xMax = crossword[0].length;
            System.out.println(xMax);


            for (int y = 0;  y < yMax; y++) {
                int i = 0;
                int j = 0;
                for (int x = 0; x < xMax; x++) {
                    //System.out.println("x: " + (x) + ", y: " + (y));
                    if ((x + i) < xMax && (y + i) < yMax ){
                        //stringBuilder = stringBuilder.append((char) crossword[y+i][x+i]);
                        System.out.println((char) crossword[y + i][x + i] + " (" + (y + i) + ", " + (x + i) + ")");

                    } else {
                        continue;
                    }
                    i++;
                    j++;
                }

                System.out.println(stringBuilder);

//                if (stringBuilder.toString().contains(words[w]) || stringBuilder.reverse().toString().contains(words[w])) {
//
//                }
                stringBuilder.setLength(0);

            }
            //
        }

        //System.out.println(wordList);
        return wordList;
    }



    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
