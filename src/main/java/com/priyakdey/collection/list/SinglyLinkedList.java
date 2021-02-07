package com.priyakdey.collection.list;

import com.priyakdey.collection.exception.NoElementException;
import com.sun.management.UnixOperatingSystemMXBean;

import java.util.StringJoiner;

/**
 * LinkedList is a dynamic array of ever growing size, which does not need to be defined while initializing.
 * Due to its dynamic allocation, LinkedList is a good DS for ease of insertion/deletion of elements.
 * This is a SinglyLinkedList implementation, which allows traversal only in one direction.
 * SinglyLinkedList does not support NULL elements.
 *
 * @param <T>
 * @author priyak
 * @see <a href="http://cslibrary.stanford.edu/103/LinkedListBasics.pdf">LinkedList Basics PDF</a>
 */
public class SinglyLinkedList<T> {
    private Node<T> head;
    private long size;

    public SinglyLinkedList() {
        /* Initialize an empty list with head pointed to NULL */
    }

    public SinglyLinkedList(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Collection does not support null.");
        }
        this.head = new Node<>(t);
        this.size = 1;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return long - number of elements
     */
    public long size() {
        return this.size;
    }

    /**
     * String representation of the list.
     * In case T is user-defined type, {@link Object#toString()} needs to be overwritten for
     * proper human readable format.
     *
     * @return String - representation of the list
     */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        if (head != null) {
            Node<T> node = head;
            for (int i = 0; i < size; i++) {
                joiner.add(node.t.toString());
                node = node.next;
            }
        }

        return joiner.toString();
    }

    /**
     * Appends the element to the end of the list.
     * If the list empty, the element becomes the head node.
     *
     * @param t - element to insert
     */
    public void append(T t) {
        if (head == null) {
            head = new Node<>(t);
            size = 1;
            return;
        }
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node<>(t);
        size++;
    }

    /**
     * Removes the last element of from the list.
     * In case of an empty list, it throws {@link NoElementException}.
     *
     * @return T - element that was popped
     * @throws NoElementException in the event of list is empty
     */
    public T pop() {
        if (size == 0) {
            throw new NoElementException("List is empty.");
        }
        if (size == 1) {
            T t = head.t;
            head = null;
            size = 0;
            return t;
        }
        Node<T> node = head;
        Node<T> penultimateNode = null;
        while (node.next != null) {
            penultimateNode = node;
            node = node.next;
        }
        penultimateNode.next = null;
        size--;
        return node.t;
    }

    /**
     * Returns if the list is empty or not
     *
     * @return boolean If the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        private final T t;
        private Node<T> next;

        private Node(T t) {
            this.t = t;
        }
    }
}
