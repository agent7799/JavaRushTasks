package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread = new Thread();

    public TaskManipulator() {
    }

    @Override
        public void run() {
        Thread current = Thread.currentThread();
            while (!current.isInterrupted()){
                System.out.println(current.getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    /** если нить уже закончила работу, то вызов Thread.sleep(100) выбросит
                        исключение, поэтому break
                        break;
                    */
                    break;
                }
            }
        }


    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
