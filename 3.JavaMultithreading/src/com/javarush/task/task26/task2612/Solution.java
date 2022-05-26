package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/

public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field
        boolean lockIsFree = lock.tryLock();
        try{
            if (lockIsFree){
                lock.lock();
                actionIfLockIsFree();
                lock.unlock();
            }else{
                // access the resource protected by this lock
                actionIfLockIsBusy();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (lockIsFree){
                lock.unlock();
            }
        }
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}
