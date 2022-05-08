package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{

    Thread target;
    State state;
    State newState;

    public LoggingStateThread(Thread loggedThread) {
        this.target = loggedThread;
        this.target.setDaemon(true);
    }

    @Override
    public void run() {
        state = target.getState();
        System.out.println(state);
        while (!isInterrupted()){
            newState = target.getState();

                while(state!=newState){
                    System.out.println(newState);
                    state = newState;
                }

            if (newState == State.TERMINATED){
                this.interrupt();
            }


        }

    }
}
