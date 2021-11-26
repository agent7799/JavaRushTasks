package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream name;


    public AmigoOutputStream(FileOutputStream name) throws FileNotFoundException {
        super(String.valueOf(name));
        this.name = name;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(int b) throws IOException {
        name.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        name.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        name.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        name.flush();
    }

    @Override
    public void close() throws IOException {
        flush();
        String s = "JavaRush © All rights reserved.";
        name.write(s.getBytes());
        name.close();
    }
}
