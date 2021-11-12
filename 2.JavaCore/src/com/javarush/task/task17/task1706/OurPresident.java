package com.javarush.task.task17.task1706;


public class OurPresident {
    private static OurPresident president;

    static {
        synchronized ( president =  new OurPresident()) {}
        /*
        Singleton паттерн значит, что должен существовать только один объект
        класса. Что бы быть уверенным, что объект один (а не создан двумя
        потоками одновременно), он и синхронизируется.
         */
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}

