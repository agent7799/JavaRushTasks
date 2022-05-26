package com.javarush.task.task26.task2609;

/* 
Распределение элементов по корзинам с собственным локом

5. В методе get() класса Solution в synchronized блоке используй lock из массива locks в зависимости от хэша объекта и количества лок объектов.
synchronized (locks[hash % NUMBER_LOCKS]) - индекс элемента массива lock : остаток от деления hash  на NUMBER_LOCKS

6. В методе clear() класса Solution в synchronized блоке используй lock из массива locks в зависимости от индекса элемента и количества лок объектов.
synchronized (locks[i % NUMBER_LOCKS]) - индекс элемента массива lock : остаток от деления индекса i на NUMBER_LOCKS
*/

public class Solution {
    private static final int NUMBER_LOCKS = 12;
    private final Node[] buckets;
    private final Object[] locks;

    static class Node {
        public Node next;
        public Object key;
        public Object value;
    }

    public Solution(int numberBuckets) {
        buckets = new Node[numberBuckets];
        locks = new Object[NUMBER_LOCKS];
        for (int i = 0; i < NUMBER_LOCKS; i++) {
            locks[i] = new Object();
        }
    }

    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public Object get(Object key) {
        int hash = hash(key);

        for (Object lock : locks) {
            synchronized (locks[hash % NUMBER_LOCKS]) {
                for (Node m = buckets[hash]; m != null; m = m.next) {
                    if (m.key.equals(key)) return m.value;
                }
            }
        }


        return null;
    }

    public void clear() {
        for (Node bucket : buckets) {

            for (int i = 0; i < buckets.length; i++) {
                synchronized (locks[i % NUMBER_LOCKS]) {
                    buckets[i] = null;
                }
            }
        }

    }


    public static void main(String[] args) {

    }
}
