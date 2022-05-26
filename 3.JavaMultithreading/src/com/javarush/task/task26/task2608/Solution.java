package com.javarush.task.task26.task2608;

/* 
Мудрый человек думает раз, прежде чем два раза сказать

 Если использовать синхронизацию по this (это происходит автоматические если
 при объявлении метода написать synhronyzed), то как только один поток начинает
 работать с объектом (выполнять какие-то методы) другие потоки ждут пока объект
 освоболится, т.к. блокируется монитор этого объекта. А вот если сначала
 создать объект (пустышку, нам от него нужен монитор например
 Object object = new Object ()) и сделать синхронизацию по нему у одного
 метода и создать другой ( тоже пустышку что-то типа Object object2 = new Object())
 и сделать синхронизацию второго метода по второму объекту, то когда один поток
 начинает выполнять первый метод нашего объекта(не пустышки естественно) он
 блокирует монитор объекта object, а не свой и потому второй поток сможет
 выполнять второй метод этого же объекта, ведь он синхронизируется по object2,
 но он не сможет выполнять первый метод так как монитор по которому синхронизируется
 первый метод занят.
*/

public class Solution {
    int var1;
    int var2;
    int var3;
    int var4;

    public Solution(int var1, int var2, int var3, int var4) {

        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;

    }

    public int getSumOfVar1AndVar2() {
        Object o1 = new Object();
        synchronized(o1)
        {
            return var1 + var2;
        }


    }

    public  int getSumOfVar3AndVar4() {
        Object o2 = new Object();
        synchronized(o2)
        {
            return var3 + var4;
        }

    }

    public static void main(String[] args) {

    }
}
