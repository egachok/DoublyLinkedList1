package org.dmitrydunai;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.Iterator;

@Data
@RequiredArgsConstructor
public class DoublyLinkedList <E> implements Iterable<E>, ReverseIterable<E>{
    protected Node<E> head;
    protected Node<E> tail;
    protected int size;

    public DoublyLinkedList(int size) {
        this.size = size;
    }

    public void insertAtBegin(E data) {
        Node<E> newNode = new Node<E>(data, null, head);
        if (head != null)
            head.previous = newNode;
        head = newNode;
        if (tail == null)
            tail = newNode;
        size++;
    }

    public void insertAtEnd(E data) {
        Node<E> newNode = new Node<E>(data, tail, null);
        if (tail != null)
            tail.next = newNode;
        tail = newNode;
        if (head == null)
            head = newNode;
        size++;
    }

    public void insertAtMid(int position, E data) {
        if (position <= 0)
            insertAtBegin(data);
        else if (position >= size)
            insertAtEnd(data);
        else {
            Node<E> newNode = new Node<E>(data);
            Node<E> currNode = head;
            for (int i = 1; i < position - 1; i++) {
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            newNode.previous = currNode;
            currNode.next.previous = newNode;
            currNode.next = newNode;
            size++;
        }
    }

    public Node<E> deleteAtBegin() {
        if (head == null || size == 0)
            return null;
        else {
            Node<E> temp = head;
            head = head.next;
            if (head != null)
                head.previous = null;
            size--;
            return temp;
        }
    }

    public Node<E> deleteAtEnd() {
        if (head == null || size == 0)
            return null;
        else {
            Node<E> temp = tail;
            tail = tail.previous;
            if (tail != null)
                tail.next = null;
            size--;
            return temp;
        }
    }

    public Node<E> deleteByKey(E data) {
        if (head == null || size == 0)
            return null;
        else {
            Node<E> currNode = head;
            while (currNode != null) {
                if (currNode.value.equals(data) && currNode.next != null) {
                    currNode.previous.next = currNode.next;
                    currNode.next.previous = currNode.previous;
                    size--;
                    return currNode;
                }
                else if (currNode.value.equals(data) && currNode.next == null) {
                    currNode.previous.next = null;
                    size--;
                    return currNode;
                }
                currNode = currNode.next;
            }
        }
        return null;
    }

    public Node<E> deleteAtPosition(int position) {
        if (position <= 1)
            return deleteAtBegin();
        else if (position >= size)
            return deleteAtEnd();
        else {
            Node<E> currNode = head;
            for (int i = 1; i < position; i++) {
                currNode = currNode.next;
            }
            currNode.previous.next = currNode.next;
            currNode.next.previous = currNode.previous;
            size--;
            return currNode;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    @Override
    public ReverseIterator<E> reverseIterator() {
        return new ReverseIterator<E>() {
            Node <E> node = tail;
            @Override
            public boolean hasPreviuos() {
                if(reverseIterator() == null) {
                    return false;
                }
                if(reverseIterator() != null) {
                    return true;
                }
                return false;
            }

            @Override
            public E previous() {
                E value = node.value;
                node = node.previous;
                return value;
            }
        };
    }
}