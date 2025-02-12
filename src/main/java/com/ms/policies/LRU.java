package com.ms.policies;

import com.ms.datastructures.DoublyLinkedList;
import com.ms.datastructures.Node;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> implements ICache<K, V> {
    private DoublyLinkedList list;
    private Map<K, Node> hmap;
    private int maxCapacity;

    public LRU(int capacity) {
        maxCapacity = capacity;
        list = new DoublyLinkedList();
        hmap = new HashMap<K, Node>();
    }

    @Override
    public V get(K key) {
        if (hmap.containsKey(key)) {
            Node nodeToRemove = hmap.get(key);
            hmap.remove(key);
            list.removeNode(nodeToRemove);

            Node newNode = nodeToRemove;
            hmap.put(key, newNode);
            list.addNextToHead(newNode);

            return (V) newNode.getValue();
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        if(hmap.containsKey(key)) {
            Node nodeToRemove = hmap.get(key);
            hmap.remove(key);
            list.removeNode(nodeToRemove);

            Node newNode = new Node(key, value);
            hmap.put(key, newNode);
            list.addNextToHead(newNode);
        } else {
            if(hmap.size() == maxCapacity) {
                Node nodeToRemove = list.removeFromTail();
                hmap.remove(nodeToRemove.getKey());

                Node newNode = new Node(key, value);
                hmap.put(key, newNode);
                list.addNextToHead(newNode);
            } else {
                Node newNode = new Node(key, value);
                hmap.put(key, newNode);
                list.addNextToHead(newNode);
            }
        }
    }
}

