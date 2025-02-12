package com.ms.datastructures;

public class Node<K, V> {
    private K key;
    private V value;
    Node next;
    Node prev;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
