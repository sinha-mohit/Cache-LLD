package com.ms.policies;

import com.ms.datastructures.DoublyLinkedList;
import com.ms.datastructures.Node;

import java.util.HashMap;
import java.util.Map;

public class LFU<K, V> implements ICache<K, V> {
    private Map<K, Node<K, V>>  hmap;
    private Map<Integer, DoublyLinkedList<K, V>> freqListMap;
    int maxCapacity;
    int minFrequency;

    public LFU(int capacity) {
        maxCapacity = capacity;
        minFrequency = 0;
        hmap = new HashMap<>();
        freqListMap = new HashMap<>();
    }


    @Override
    public void put(K key, V value) {
        if(maxCapacity == 0) return;

        if(hmap.containsKey(key)) {
            Node<K, V> node = hmap.get(key);
            node.setValue(value);
            updateFreqListMap(node);
        } else {
            if(hmap.size() == maxCapacity) {
                if(freqListMap.containsKey(minFrequency)) {
                    Node<K, V> removedNode = freqListMap.get(minFrequency).removeFromTail();
                    if (freqListMap.get(minFrequency).getCurrSize() == 0) {
                        freqListMap.remove(minFrequency);
                    }
                    hmap.remove(removedNode.getKey()); // now size reduced by 1
                }
            }

            // new value has to be added who is not there previously
            minFrequency = 1;
            DoublyLinkedList<K, V> newList = new DoublyLinkedList<>();
            if(freqListMap.containsKey(minFrequency)) {
                newList = freqListMap.get(minFrequency);
            }
            Node<K, V> newNode = new Node<>(key, value);
            newList.addNextToHead(newNode);
            freqListMap.put(minFrequency, newList);
            hmap.put(key, newNode);
        }
    }

    @Override
    public V get(K key) {
        if(hmap.containsKey(key)) {
            Node<K, V> node = hmap.get(key);
            V value = node.getValue();
            updateFreqListMap(node);
            return value;
        }
        return null;
    }

    @Override
    public void changeCapacity(int newCapacity) {

    }

    private void updateFreqListMap(Node<K, V> node) {
        hmap.remove(node.getKey());
        freqListMap.get(node.getCount()).removeNode(node);

        if(node.getCount() == minFrequency && freqListMap.get(node.getCount()).getCurrSize() == 0) {
            freqListMap.remove(node.getCount());
            minFrequency++;
        }

        DoublyLinkedList<K, V> nextHigherFreqencyList = new DoublyLinkedList<>();
        if(freqListMap.containsKey(node.getCount()+1)) {
            nextHigherFreqencyList = freqListMap.get(node.getCount()+1);
        }

        node.setCount(node.getCount()+1);
        nextHigherFreqencyList.addNextToHead(node);
        freqListMap.put(node.getCount(), nextHigherFreqencyList);
        hmap.put(node.getKey(), node);
    }
}
