package com.javarush.task.task25.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        //close all resources here
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                //close all resources here by using proper SocketTask method
                //call super-class method in finally block
                try {
                    //Метод cancel для локального класса внутри
                    // метода newTask должен закрывать ресурсы
                    // SocketTask и вызвать cancel у родительского
                    // класса.
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    //Метод у родительского класса должен
                    // быть вызван, даже если во время закрытия
                    // ресурсов было выкинуто исключение.
                    super.cancel(mayInterruptIfRunning);
                }
                return false;
            }
        };
    }
}