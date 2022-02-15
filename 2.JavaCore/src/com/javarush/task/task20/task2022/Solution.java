package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

/**
 * 1) Так как stream является несериализуемым, помечаем его как transient;
 * 2) Так как при загрузке объекта поток stream не сохранился, нужно его создать
 * и присвоить заново в методе readObject.
 * 3) Чтобы его инициализировать, нам нужно имя файла, который был у оригинала.
 * Это мы можем сделать, сохранив его как поле класса и присвоить в конструкторе.
 */

public class Solution implements Serializable, AutoCloseable {
   transient private FileOutputStream stream;
   static String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        stream = new FileOutputStream(fileName, true);
        in.defaultReadObject();
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {

        try {
            Solution sol = new Solution("C:\\java\\temp.txt");
            sol.writeObject("any data");
            


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
