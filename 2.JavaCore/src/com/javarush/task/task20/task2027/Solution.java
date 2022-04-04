package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}

//                {'f', 'd', 'e', 'e', 'l', 'k'},
//                {'u', 's', 'a', 'm', 'e', 'o'},
//                {'l', 'a', 'a', 'o', 'o', 'v'},
//                {'m', 'm', 'p', 'm', 'r', 'h'},
//                {'m', 'e', 'm', 'a', 'e', 'h'},
//                {'h', 'o', 'm', 'e', 'p', 'j'}
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

        int hor = crossword[0].length;
        int ver = crossword.length;
        System.out.println("rows yMax crossword.length " + ver);
        System.out.println("columns xMax crossword[0].length " + hor);

        for (int w = 0; w < words.length; w++) {

            //System.out.println("Looking for " + words[w]);

           //строки - rows
            for (int y = 0; y < crossword.length; y++) {
                int columns = crossword[y].length;
                for (int x = 0; x < columns; x++) {
                    stringBuilder = stringBuilder.append((char) crossword[y][x]);
                }
                //System.out.println(y + " row: " + stringBuilder);
                //поиск в строке прямой
                if (stringBuilder.toString().contains(words[w])) {
                    Word tempWord = new Word(words[w]);
                    tempWord.setStartPoint(stringBuilder.indexOf(words[w]), y);
                    tempWord.setEndPoint(tempWord.startX + words[w].length()-1, y);
                    wordList.add(tempWord);
                    //System.out.println(tempWord);
                    tempWord = null;
                }
                //поиск в строке обратный
                    if (stringBuilder.reverse().toString().contains(words[w])){
                        Word tempWord = new Word(words[w]);
                        tempWord.setStartPoint( columns -1  - stringBuilder.indexOf(words[w]), y);
                        tempWord.setEndPoint( tempWord.startX - (words[w].length()-1), y);
                        wordList.add(tempWord);
                        //System.out.println(tempWord);
                        tempWord = null;
                    }
                stringBuilder.setLength(0);
            }

            //столбцы - columns
            for (int y = 0; y < crossword[0].length; y++) {
                int rows = crossword.length;
                for (int x = 0; x < crossword.length; x++) {
                    stringBuilder = stringBuilder.append((char) crossword[x][y]);
                }
                //System.out.println(y + " column: " + stringBuilder);
                //поиск в столбце прямой
                if (stringBuilder.toString().contains(words[w])) {
                    Word tempWord = new Word(words[w]);
                    tempWord.setStartPoint(y, stringBuilder.indexOf(words[w]));
                    tempWord.setEndPoint(y, stringBuilder.indexOf(words[w]) + (words[w].length()-1));
                    wordList.add(tempWord);
                    //System.out.println(tempWord);
                    tempWord = null;
                }
                //поиск в столбце обратный
                    if (stringBuilder.reverse().toString().contains(words[w])){
                        Word tempWord = new Word(words[w]);
                        tempWord.setStartPoint( y, rows - 1 - stringBuilder.indexOf(words[w]));
                        tempWord.setEndPoint( y, rows - 1 - stringBuilder.indexOf(words[w])-  (words[w].length()-1));
                        wordList.add(tempWord);
                        //System.out.println(tempWord);
                        tempWord = null;
                    }
                stringBuilder.setLength(0);
            }

//            //диагонали
//            for (int y = ver;  y > 0; y--) {
//
//                for (int x = 0; x < hor; x++) {
//                    int i = x;
//                    int j = y;
//
//                    if ((y + i) < hor &&  (y + i) >= 0 && (x - j) < ver && (x - j) >= 0){
//                        System.out.print("x: " + (x) + ", y: " + (y + i) + "   ");
//                        stringBuilder = stringBuilder.append((char) crossword[x][y + i]);
//                        System.out.println((char) crossword[x][y + i ] + " (" + (y + i) + ", " + (x) + ")");
//                        j++;
//                    } else {
//                        continue;
//                    }
//                    i++;
//                }
//                //диагональ прямая
//                System.out.println(stringBuilder);
//                if (stringBuilder.toString().contains(words[w])) {
//                    Word tempWord = new Word(words[w]);
//                    tempWord.setStartPoint(y + stringBuilder.indexOf(words[w]), stringBuilder.indexOf(words[w]));
//                    tempWord.setEndPoint(tempWord.startX + (words[w].length()-1), tempWord.startY + (words[w].length()-1));
//                    wordList.add(tempWord);
//                    System.out.println(tempWord);
//                    tempWord = null;
//                }
//                //диагональ обратная
//                System.out.println(stringBuilder);
//                if (stringBuilder.reverse().toString().contains(words[w])) {
//                    Word tempWord = new Word(words[w]);
//                    tempWord.setEndPoint(y + stringBuilder.indexOf(words[w]), stringBuilder.indexOf(words[w]));
//                    tempWord.setStartPoint(tempWord.endX + (words[w].length()-1), tempWord.endY + (words[w].length()-1));
//                    wordList.add(tempWord);
//                   // System.out.println(tempWord);
//                    tempWord = null;
//                }



//                if (stringBuilder.toString().contains(words[w]) || stringBuilder.reverse().toString().contains(words[w])) {
//
//                }
//по диагонали вправо
                for (int i = 0; i < ver; i++) {
                    for (int j = 0; j < hor; j++) {
                        int iTemp = i;
                        int jTemp = j;
                        StringBuilder sb = new StringBuilder();
                        while (iTemp < ver && jTemp < hor) {
                            sb.append((char) crossword[iTemp][jTemp]);
                            iTemp++;
                            jTemp++;
                        }
                        String horLine = sb.toString();
                        if (horLine.contains(words[w])) {
                            Word word = new Word(words[w]);
                            word.setStartPoint(j + horLine.indexOf(words[w]), i + horLine.indexOf(words[w]));
                            word.setEndPoint(j + horLine.indexOf(words[w]) + words[w].length() - 1, i + horLine.indexOf(words[w]) + words[w].length() - 1);

                            wordList.add(word);
                            continue ;
                        }
                        String horReverse = sb.reverse().toString();
                        if (horReverse.contains(words[w])) {
                            Word word = new Word(words[w]);
                            word.setStartPoint(jTemp - 1 - horReverse.indexOf(words[w]), iTemp - 1 - horReverse.indexOf(words[w]));
                            word.setEndPoint(jTemp - horReverse.indexOf(words[w]) - words[w].length(), iTemp - horReverse.indexOf(words[w]) - words[w].length());

                            wordList.add(word);
                            continue ;
                        }
                    }
                }

                //по диагонали влево
                for (int i = 0; i < ver; i++) {
                    for (int j = hor - 1; j >= 0; j--) {
                        int iTemp = i;
                        int jTemp = j;
                        StringBuilder sb = new StringBuilder();
                        while (iTemp < ver && jTemp >= 0) {
                            sb.append((char) crossword[iTemp][jTemp]);
                            iTemp++;
                            jTemp--;
                        }

                        String horLine = sb.toString();
                        if (horLine.contains(words[w])) {
                            Word word = new Word(words[w]);
                            word.setStartPoint(j - horLine.indexOf(words[w]), i + horLine.indexOf(words[w]));
                            word.setEndPoint(j - horLine.indexOf(words[w]) - words[w].length() + 1, i + horLine.indexOf(words[w]) + words[w].length() - 1);

                            wordList.add(word);
                            continue ;
                        }
                        String horReverse = sb.reverse().toString();
                        if (horReverse.contains(words[w])) {
                            Word word = new Word(words[w]);
                            word.setStartPoint(jTemp + 1 + horReverse.indexOf(words[w]), iTemp - 1 - horReverse.indexOf(words[w]));
                            word.setEndPoint(jTemp + horReverse.indexOf(words[w]) + words[w].length(), iTemp - horReverse.indexOf(words[w]) - words[w].length());
                            wordList.add(word);
                            continue ;
                        }
                    }
                }

                stringBuilder.setLength(0);
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
