package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.*;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            //String fileName = "C:\\java\\test.txt";

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));         //true means append to file


            Map<Integer, String> goods = new TreeMap<>();
            String s;
            while (fileReader.ready()){
                s = fileReader.readLine();
                goods.put(Integer.parseInt(s.substring(0, 8).trim()), s.substring(8));
            }
            int maxId = Collections.max(goods.keySet());
            //System.out.println(goods);
            //System.out.println(maxId);


            if (args.length == 0) {

            }else if (args[0].equals("-c")){
                String id = (maxId + 1 + "");
                String productName = args[1];
                String price = args[2];
                String quantity = args[3];
                for (int i = args[1].length(); i < 30; i++) {
                    productName = productName + " ";                                  //ToDo replace  "." to " "
                }

                for (int i = args[2].length(); i < 8; i++) {
                    price = price + " ";                                  //ToDo replace  "." to " "
                }

                for (int i = args[3].length(); i < 4; i++) {
                    quantity = quantity + " ";                                  //ToDo replace  "." to " "
                }

                goods.put(maxId+1, productName + price + quantity);

                for (int i = id.length(); i < 8; i++) {
                    id = id + " ";                                          //ToDo replace  "." to " "
                }
                String result = "\n" + id + productName + price + quantity;
               // System.out.println(result);
                fileWriter.write(result);
            }

            reader.close();
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
