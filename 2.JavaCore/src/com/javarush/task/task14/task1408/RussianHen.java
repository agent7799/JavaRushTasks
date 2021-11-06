package com.javarush.task.task14.task1408;

public class RussianHen extends Hen implements Country{
    @Override
    public int getCountOfEggsPerMonth() {
        return 100;
    }

    @Override
    public String getDescription() {
        String returnString = (super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц."      );
        return returnString;
    }
}
