package com.ms.policies;

public interface ICache<K, V> {
    void put(K key, V value);
    V get(K key);
    void changeCapacity(int newCapacity);
}
