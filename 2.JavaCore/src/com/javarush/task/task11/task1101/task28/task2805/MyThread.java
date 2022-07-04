package com.javarush.task.task11.task1101.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static volatile AtomicInteger priority = new AtomicInteger(MIN_PRIORITY);
    

    private synchronized void correctPriority(){
        int newPriority = priority.getAndIncrement();

        if(getThreadGroup() != null){
            if (newPriority > getThreadGroup().getMaxPriority()) {
                newPriority = getThreadGroup().getMaxPriority();
            }
            setPriority(newPriority);
            }
            if (priority.get() > MAX_PRIORITY) {
                priority.set(MIN_PRIORITY);
            }
        }


    public MyThread() {
        correctPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        correctPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        correctPriority();
    }

    public MyThread(String name) {
        super(name);
        correctPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        correctPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        correctPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        correctPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        correctPriority();
    }

//    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
//        super(group, target, name, stackSize, inheritThreadLocals);
//    }


}
