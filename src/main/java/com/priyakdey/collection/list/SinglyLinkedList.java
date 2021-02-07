package com.priyakdey.collection.list;

import com.priyakdey.collection.exception.NoElementException;

import java.util.NoSuchElementException;
import java.util.Objects;
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
        if (t == null) {
            throw new IllegalArgumentException("Null Value cannot be inserted.");
        }
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

    /**
     * Removes the first element in the list.
     * Throws {@link NoElementException} if the list if empty
     *
     * @return T the evicted element
     */
    public T shift() {
        if (size == 0) {
            throw new NoElementException("The list is empty.");
        }
        Node<T> node = head;
        head = head.next;
        size--;
        return node.t;
    }

    /**
     * Adds the element to the head of the list and shifts rests of the element by 1 position
     *
     * @param t element to insert
     */
    public void unshift(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Null Value cannot be inserted.");
        }
        if (size == 0) {
            append(t);
            return;
        }
        Node<T> node = head;
        head = new Node<>(t);
        head.next = node;
        size++;
    }

    /**
     * Returns the zero-based index of the first occurrence of the input argument
     * In case the list is empty, it throws {@link NoElementException}.
     * In case the element is not in the list it throws {@link NoSuchElementException}
     *
     * @param t element to find
     * @return long index of the element
     * @throws NoElementException     if the list is empty
     * @throws NoSuchElementException if the element is not present in the list
     */
    public long indexOf(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Null value is not supported.");
        }
        if (size == 0) {
            throw new NoElementException("The list is empty.");
        }
        Node<T> node = head;
        for (long i = 0; i < size; i++) {
            if (Objects.equals(t, node.t)) {
                return i;
            }
            node = node.next;
        }
        throw new NoSuchElementException("Element is not in the list.");
    }

    /**
     * Returns the element at the requested position which is zero-based.
     * In case the index is negative, {@link IllegalArgumentException} is thrown.
     * In case the index is out of range of size, {@link IndexOutOfBoundsException} is thrown.
     *
     * @param index position
     * @return T element at index position
     * @throws IllegalArgumentException when index is negative
     * @throws IndexOutOfBoundsException when index is out of range of the size of the list
     */
    public T get(long index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative.");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index cannot be equal to or more than size(" + size + ") of the list");
        }
        Node<T> node = head;
        for (long i = 0; i < index; i++) {
            node = node.next;
        }
        return node.t;
    }

    public void insertAt(T t, long index) {
        if (t == null || index < 0) {
            throw new IllegalArgumentException("Illegal argument has been passed.");
        }
        if (index > size) {
            throw new IndexOutOfBoundsException("Index cannot be equal to or more than size(" + size + ") of the list");
        }
        if (index == size) {
            append(t);
            return;
        }
        Node<T> prev = null;
        Node<T> node = head;
        for (long i = 0; i < index; i++) {
            prev = node;
            node = node.next;
        }
        Node<T> newNode = new Node<>(t);
        prev.next = newNode;
        newNode.next = node;
        size++;
    }
}
