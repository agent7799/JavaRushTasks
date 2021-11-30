package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.*;

/* 
Прайсы 2
*/

public class Solution {

    static int id;
    static String productName;
    static String price;
    static String quantity;

        private static int getId(String idString) {
            return Integer.parseInt(idString.trim());
        }

        private static String formatId(String idString){
            for (int i = idString.length(); i < 8; i++) {
                idString = idString + " ";
            }
            return idString;
        }

        private static String formatProductName(String productName){
            for (int i = productName.length(); i < 30; i++) {
                productName = productName + " ";
            }
            return productName;
        }

        private static String formatPrice(String price) {
            for (int i = price.length(); i < 8; i++) {
                price = price + " ";
            }
            return price;
        }

        private static String formatQuantity(String quantity) {
            for (int i = quantity.length(); i < 4; i++) {
                quantity = quantity + " ";
            }
            return quantity;
        }


        public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            //String fileName = "C:\\java\\test.txt";
            reader.close();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            Map<Integer, String> goods = new LinkedHashMap<>();
            String s;
            while (fileReader.ready()) {
                s = fileReader.readLine();
                System.out.println(s);
                goods.put(Integer.parseInt(s.substring(0, 8).trim()), s.substring(8));
            }

//            for (Map.Entry<Integer, String> entry : goods.entrySet()){
//                System.out.println(formatId(entry.getKey().toString()) + " :original: " +  entry.getValue());
//            }

//            for (Integer key: goods.keySet()) {
//                System.out.println("" + formatId(key.toString()) + goods.get(key));
//            }

            fileReader.close();

            if (args.length != 0) {

                if (args[0].equals("-u")) {
                    BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
                        id = getId(formatId(args[1]));
                        productName = formatProductName(args[2]);
                        price = formatPrice(args[3]);
                        quantity = formatQuantity(args[4]);

                        System.out.println("\n " + "entry to be replaced: "+ id + ": " + productName + price + quantity + "\n");

                        goods.replace(id, (productName + price + quantity));

                    for (Integer key: goods.keySet()) {
                        System.out.println("" + formatId(key.toString()) + goods.get(key));
                        fileWriter.write(formatId( formatId(key.toString()) + goods.get(key)  + "\n"));
                    }

//                        for (Map.Entry<Integer, String> entry : goods.entrySet()){
//                            System.out.println(formatId(entry.getKey().toString()) + " :replaced: " +  entry.getValue());
//                            fileWriter.write(formatId(entry.getKey().toString())  +  entry.getValue()  + "\n");
//                        }
                    fileWriter.close();

                    }else if (args[0].equals("-d")) {
                        goods.remove(getId(args[1]));
                    BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));         //true means append to file
                    for (Map.Entry<Integer, String> entry : goods.entrySet()){
                        fileWriter.write(formatId(entry.getKey().toString()) +  entry.getValue() + "\n");
                    }
                    fileWriter.close();
                    }
            }

//            for (Map.Entry<Integer, String> entry : goods.entrySet()){
//                System.out.println(formatId(entry.getKey().toString()) + " : final : " +  entry.getValue());
//            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }finally {

        }

    }
}
