package org.dmitrydunai;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(15);
        dll.insertAtBegin(1);
        dll.insertAtBegin(4);
        dll.insertAtBegin(12);
        dll.insertAtEnd(56);
        dll.insertAtEnd(22);

        Iterator<Integer> iterator = dll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        ReverseIterator<Integer> reverseIterator = dll.reverseIterator();
        while (reverseIterator.hasPreviuos()) {
            System.out.println(reverseIterator.previous());
        }
    }
}