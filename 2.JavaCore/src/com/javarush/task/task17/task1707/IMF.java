package com.javarush.task.task17.task1707;


public class IMF {

    private static IMF imf;

    public static IMF getFund() {
        //add your code here - добавь код тут

        int count = 1000000;
        long begin = System.currentTimeMillis();
        long end;
        for (int i = 0; i < count; i++)
        {

            synchronized (IMF.class){
                if (imf == null) {
                    imf = new IMF();
                }
            }

        }
        end = System.currentTimeMillis();
        System.out.println(end - begin);

        return imf;
    }

    private IMF() {
    }
}
