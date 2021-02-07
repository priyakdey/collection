package com.priyakdey.collection.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}