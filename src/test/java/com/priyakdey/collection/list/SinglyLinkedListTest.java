package com.priyakdey.collection.list;

import com.priyakdey.collection.exception.NoElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("SinglyLinkedList")
class SinglyLinkedListTest {

    @Test
    @DisplayName("Should throw IllegalArgumentException")
    void init_with_null() {
        assertThrows(IllegalArgumentException.class, () -> new SinglyLinkedList<Integer>(null));
    }

    @Test
    @DisplayName("Initialize empty list")
    void init_empty_list() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }

    @Test
    @DisplayName("Initialize list with one node")
    void init_list() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(123);
        assertEquals(1, list.size());
        assertEquals("[123]", list.toString());
    }

    @Test
    @DisplayName("#append(): Should throw IllegalArgumentException")
    void append_illegal_argument_exception() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.append(null));
    }

    @Test
    @DisplayName("#append(t): When the list is empty")
    void append_to_empty_list() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(100);
        assertEquals(1, list.size());
        assertEquals("[100]", list.toString());
    }

    @Test
    @DisplayName("#append(t): Should append to end of list")
    void append_to__list() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(11);
        list.append(111);
        list.append(1111);
        assertEquals(4, list.size());
        assertEquals("[1,11,111,1111]", list.toString());
    }

    @Test
    @DisplayName("#pop(): Should throw NoElementException")
    void pop_from_empty_list() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertThrows(NoElementException.class, list::pop);
    }

    @Test
    @DisplayName("#pop(): Should pop the head element")
    void pop_from_list_size_one() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(100);
        Integer element = list.pop();
        assertEquals(0, list.size());
        assertEquals(100, element);
        assertEquals("[]", list.toString());
    }

    @Test
    @DisplayName("#pop(): Should pop the last element")
    void pop_from_list_() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(11);
        list.append(111);
        list.append(1111);
        list.append(11111);

        Integer element = list.pop();
        assertEquals(4, list.size());
        assertEquals(11111, element);
        assertEquals("[1,11,111,1111]", list.toString());

        element = list.pop();
        assertEquals(3, list.size());
        assertEquals(1111, element);
        assertEquals("[1,11,111]", list.toString());

        element = list.pop();
        assertEquals(2, list.size());
        assertEquals(111, element);
        assertEquals("[1,11]", list.toString());

        element = list.pop();
        assertEquals(1, list.size());
        assertEquals(11, element);
        assertEquals("[1]", list.toString());

        element = list.pop();
        assertEquals(0, list.size());
        assertEquals(1, element);
        assertEquals("[]", list.toString());
    }

    @Test
    @DisplayName("#isEmpty(): Should return false")
    void empty_scenario_one() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("First Element");
        assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("#isEmpty(): Should return true")
    void empty_scenario_two() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("#shift(): Should throw NoElementException")
    void shift_empty_list() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertThrows(NoElementException.class, list::shift);
    }

    @Test
    @DisplayName("#shift(): Should return the current head element")
    void shift() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(11);
        list.append(111);

        Integer element = list.shift();
        assertEquals(2, list.size());
        assertEquals(1, element);
        assertEquals("[11,111]", list.toString());

        element = list.shift();
        assertEquals(1, list.size());
        assertEquals(11, element);
        assertEquals("[111]", list.toString());

        element = list.shift();
        assertEquals(0, list.size());
        assertEquals(111, element);
        assertEquals("[]", list.toString());
    }

    @Test
    @DisplayName("#unshift(): Should throw IllegalArgumentException")
    void unshift_illegal_argument_exception() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.unshift(null));
    }

    @Test
    @DisplayName("#unshift(): should append to the head of the list")
    void unshift() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.unshift(1);
        assertEquals(1, list.size());
        assertEquals("[1]", list.toString());

        list.unshift(2);
        assertEquals(2, list.size());
        assertEquals("[2,1]", list.toString());

        list.unshift(3);
        assertEquals(3, list.size());
        assertEquals("[3,2,1]", list.toString());
    }

    @Test
    @DisplayName("#indexOf(): Should throw IllegalArgumentException")
    void indexOf_throws_illegal_argument_exception() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.indexOf(null));
    }

    @Test
    @DisplayName("#indexOf(): Should throw NoElementException")
    void indexOf_throws_no_element_exception() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertThrows(NoElementException.class, () -> list.indexOf(1));
    }

    @Test
    @DisplayName("#indexOf(): Should return index of the element")
    void indexOf_element_present() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(12);
        list.append(123);
        list.append(1234);
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(12));
        assertEquals(2, list.indexOf(123));
        assertEquals(3, list.indexOf(1234));
    }

    @Test
    @DisplayName("#indexOf(): Should throw NoSuchElementException")
    void indexOf_element_not_present() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(12);
        list.append(123);
        list.append(1234);
        assertThrows(NoSuchElementException.class, () -> list.indexOf(2));
    }

    @Test
    @DisplayName("#get(): Should throw IllegalArgumentException")
    void get_illegal_argument_exception() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.get(-1));
    }

    @Test
    @DisplayName("#get(): Should throw IndexOutOfBoundsException")
    void get_index_out_of_bounds_exception() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    @DisplayName("#get(): Should return the element from the position")
    void get_() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(12);
        list.append(123);
        assertEquals(1, list.get(0));
        assertEquals(12, list.get(1));
        assertEquals(123, list.get(2));
    }

    @Test
    @DisplayName("#insert(): Should throw IllegalArgumentException")
    void insertAt_illegal_argument_exception() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        assertThrows(IllegalArgumentException.class, () -> list.insertAt(1, -1));
        assertThrows(IllegalArgumentException.class, () -> list.insertAt(null, 1));
    }

    @Test
    @DisplayName("#insert(): Should throw IndexOutOfBoundsException")
    void insertAt_index_out_of_bounds_exception() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.insertAt(100, 2));
    }

    @Test
    @DisplayName("#insert(): Should insert at specified index")
    void insertAt() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.insertAt(5, 2);
        assertEquals(5, list.size());
        assertEquals("[1,2,5,3,4]", list.toString());
    }
}