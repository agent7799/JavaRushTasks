package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Charset utf8 = StandardCharsets.UTF_8;
        Charset windows1251 = Charset.forName("Windows-1251");

        FileInputStream is = new FileInputStream(args[0]);
        FileOutputStream os = new FileOutputStream(args[1]);

        byte[] buffer = new byte[1000];
        while (is.available() > 0){
            is.read(buffer);
            String s = new String(buffer, windows1251);
            buffer = s.getBytes(StandardCharsets.UTF_8);
            os.write(buffer);
        }

        is.close();
        os.close();
    }
}
