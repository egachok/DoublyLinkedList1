package org.dmitrydunai;

public class Node <E> {
    E value;
    Node<E> next;
    Node<E> previous;

    Node(E input) {
        this.value = input;
        previous = null;
        next = null;
    }

    Node(E input1, Node<E> prev, Node<E> next) {
        this.value = input1;
        this.previous = prev;
        this.next = next;
    }
}