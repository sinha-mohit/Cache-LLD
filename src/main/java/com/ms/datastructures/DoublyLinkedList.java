package com.ms.datastructures;

public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        Node dummyNode1 = new Node(-1, -1);
        Node dummyNode2 = new Node(-1, -1);

        dummyNode1.next = dummyNode2;
        dummyNode1.prev = null;

        dummyNode2.prev = dummyNode1;
        dummyNode2.next = null;

        head = dummyNode1;
        tail = dummyNode2;
    }

    public Node removeFromTail() {
        if (head.next == tail) return null;

        Node nodeToRemove = tail.prev;
        Node tempPrev = nodeToRemove.prev;
        Node tempNext = nodeToRemove.next;

        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;

        // delete the links
        nodeToRemove.prev = null;
        nodeToRemove.next = null;

        return nodeToRemove;
    }

    public void removeNode(Node nodeToRemove) {
        Node tempPrev = nodeToRemove.prev;
        Node tempNext = nodeToRemove.next;

        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;

        // delete the links
        nodeToRemove.prev = null;
        nodeToRemove.next = null;

    }

    public void addNextToHead(Node nodeToAdd) {
        if (nodeToAdd == null) return;

        nodeToAdd.next = head.next;
        nodeToAdd.prev = head;

        head.next = nodeToAdd;
        nodeToAdd.next.prev = nodeToAdd;

    }
}
