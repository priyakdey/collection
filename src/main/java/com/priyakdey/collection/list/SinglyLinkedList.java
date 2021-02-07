package com.priyakdey.collection.list;

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

    private static class Node<T> {
        private final T t;
        private Node<T> next;

        private Node(T t) {
            this.t = t;
        }
    }
}
