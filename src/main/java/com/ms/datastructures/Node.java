package com.ms.datastructures;

public class Node<K, V> {
    private K key;
    private V value;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    Node<K, V> next;
    Node<K, V> prev;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.count = 1;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
