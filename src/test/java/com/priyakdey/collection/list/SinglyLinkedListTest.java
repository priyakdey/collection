package com.priyakdey.collection.list;

import com.priyakdey.collection.exception.NoElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThrows(NoElementException.class, () -> list.pop());
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
}