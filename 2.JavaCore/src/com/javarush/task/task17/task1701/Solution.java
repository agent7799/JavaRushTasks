package com.javarush.task.task17.task1701;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/* 
Заметки
*/

public class Solution {

    public static void main(String[] args) {
        new NoteThread().start();
        new NoteThread().start();
    }

    public static class NoteThread extends Thread{

        @Override
        public void run(){

            for (int i = 0; i <= 999; i++){
                Note.addNote(getName() + "-Note" + i);
                    Note.index = i;
                try {
                    Thread.sleep(1);
                    Note.removeNote(getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();


                }
            }
        }

    }


    public static class Note {
        public static int index;


        public static final List<String> notes = new ArrayList<>();

        public static void addNote(String note)
        {
            notes.add(index, note);
        }

        public static void removeNote(String threadName)
        {
            String note = notes.remove(index);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            } else {
                System.out.println("Нить [" + threadName + "] удалила свою заметку [" + note + "]");
            }
        }
    }
}
