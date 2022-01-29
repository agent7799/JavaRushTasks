package com.javarush.task.task19.task1918;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName =reader.readLine();
            //tring fileName = "c:\\java\\test.txt";
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String temp = " ";

            StringBuilder readFileContent = new StringBuilder();

            while ((temp = fileReader.readLine()) != null) {
                readFileContent.append(temp);
            }
            String fileContent = readFileContent.toString().replaceAll("[\\r\\n]+", "");
            //System.out.println("filecontent: " + fileContent);
            fileReader.close();
        String tag = args[0];
        String openedTag = "<" + tag;
        String closedTag = "</" + tag;
        int openedTagIndex = fileContent.indexOf(openedTag);
        int closedTagIndex = fileContent.indexOf(closedTag);
        int closedTagCount = 0;
        ArrayList<Integer> openedTagsIndexes = new ArrayList<>();
        ArrayList<Integer> closedTagsIndexes = new ArrayList<>();

            while (openedTagIndex != -1 || closedTagIndex != -1) {
                if (openedTagIndex != -1 && openedTagIndex < closedTagIndex) {
                    openedTagsIndexes.add(openedTagIndex);
                    openedTagIndex = fileContent.indexOf(openedTag, openedTagIndex + 1);
                } else if (closedTagCount != -1 && (closedTagIndex < openedTagIndex || openedTagIndex == -1)) {
                    closedTagsIndexes.add(closedTagIndex + tag.length() + 3);
                    closedTagCount++;
                    closedTagIndex = fileContent.indexOf(closedTag, closedTagIndex + 1);
                }
            }

            Stack<String> stack = new Stack<>();
            for (int i = openedTagsIndexes.size() - 1; i >= 0; i--) {
                stack.push(fileContent.substring(openedTagsIndexes.get(i), GetNextEndTag(closedTagsIndexes, openedTagsIndexes.get(i))));
            }

            while (stack.size() > 0) {
                System.out.println(stack.pop());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int GetNextEndTag(ArrayList<Integer> closedTagsIndexes, Integer openedTagIndex) {
        Iterator<Integer> iterator = closedTagsIndexes.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next > openedTagIndex) {
                iterator.remove();
                return next;
            }
        }
        return 0;
    }

}
