package com.javarush.task.task18.task1815;

import java.util.List;
import java.util.Locale;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface{
     private TableInterface tif;


        public TableInterfaceWrapper(TableInterface tif) {
            this.tif = tif;

        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            tif.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return tif.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
           tif.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}