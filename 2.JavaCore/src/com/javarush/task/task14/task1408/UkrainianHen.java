package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen implements Country{

    @Override
    public int getCountOfEggsPerMonth() {
        return 150;

    }

    @Override
    public String getDescription() {
        String returnString = (super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц."      );
        return returnString;
    }

}
