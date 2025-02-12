package com.ms.datastructures;

public class DoublyLinkedList<K, V> {
    Node<K, V> head;
    Node<K, V> tail;
    int currSize ;
    public DoublyLinkedList() {
        Node<K, V> dummyNode1 = new Node(-1, -1);
        Node<K, V> dummyNode2 = new Node(-1, -1);

        dummyNode1.next = dummyNode2;
        dummyNode1.prev = null;

        dummyNode2.prev = dummyNode1;
        dummyNode2.next = null;

        head = dummyNode1;
        tail = dummyNode2;

        currSize = 0;
    }

    public Node<K, V> removeFromTail() {
        Node<K, V> nodeToRemove = tail.prev;
        removeNode(nodeToRemove);
        return nodeToRemove;
    }

    public void removeNode(Node<K, V> nodeToRemove) {
        Node<K, V> tempPrev = nodeToRemove.prev;
        Node<K, V> tempNext = nodeToRemove.next;

        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;

        // delete the links
        nodeToRemove.prev = null;
        nodeToRemove.next = null;

        currSize--;
    }

    public void addNextToHead(Node<K, V> nodeToAdd) {
        if (nodeToAdd == null) return;

        nodeToAdd.next = head.next;
        nodeToAdd.prev = head;

        head.next = nodeToAdd;
        nodeToAdd.next.prev = nodeToAdd;
        currSize++;
    }

    public int getCurrSize() {
        return currSize;
    }
}
