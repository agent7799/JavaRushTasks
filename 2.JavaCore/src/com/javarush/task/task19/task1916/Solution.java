package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            //String file1 = "c:\\java\\test1.txt";
            //String file2 = "c:\\java\\test2.txt";

            reader.close();

            BufferedReader fileReader1 = new BufferedReader((new FileReader(file1)));
            BufferedReader fileReader2 = new BufferedReader((new FileReader(file2)));

            ArrayList<String> oldLines = new ArrayList<>();
            ArrayList<String> newLines = new ArrayList<>();

            while (fileReader1.ready()){
               oldLines.add(fileReader1.readLine());
            }
            while (fileReader2.ready()){
               newLines.add(fileReader2.readLine());
            }

            int oldIndex = 0;
            int newIndex = 0;

            while (oldIndex < oldLines.size() && newIndex < newLines.size()){
                if (oldLines.get(oldIndex).equals(newLines.get(newIndex))){
                    lines.add(new LineItem(Type.SAME, newLines.get(newIndex)));
                    oldIndex++;
                    newIndex++;
                }else if (newIndex + 1 < newLines.size() && oldLines.get(oldIndex).equals(newLines.get(newIndex + 1))){
                    lines.add(new LineItem(Type.ADDED, newLines.get(newIndex)));
                    newIndex++;
                }else if (oldIndex + 1 < oldLines.size() && oldLines.get(oldIndex + 1).equals(newLines.get(newIndex))){
                    lines.add(new LineItem(Type.REMOVED, oldLines.get(oldIndex)));
                    oldIndex++;
                }
            }

            while (oldIndex < oldLines.size()){
                lines.add(new LineItem(Type.REMOVED, oldLines.get(oldIndex)));
                oldIndex++;
            }
            while (newIndex < newLines.size()){
                lines.add(new LineItem(Type.ADDED, newLines.get(newIndex)));
                newIndex++;
            }



            fileReader1.close();
            fileReader2.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        for (LineItem l : lines) {
            System.out.println(l.type + " " + l.line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
