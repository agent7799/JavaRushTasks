package com.javarush.task.task14.task1417;

public class USD extends Money{
    private double amount;


    public USD(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
