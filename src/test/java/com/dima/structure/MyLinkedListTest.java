package com.dima.structure;

import com.dima.model.Rabbit;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void testSimpleAdd() {
        MyLinkedList list = new MyLinkedList();
        assertEquals(0, list.size());

        list.add(new Rabbit("1_Rabbit"));
        list.add(new Rabbit("2_Rabbit"));
        list.add(new Rabbit("3_Rabbit"));
        assertEquals(3, list.size());

        list.add(new Rabbit("3_Rabbit"));
        list.add(new Rabbit("3_Rabbit"));
        list.add(new Rabbit("3_Rabbit"));
        assertEquals(6, list.size());

        list.add(new Rabbit(null));
        list.add(new Rabbit(null));
        assertEquals(8, list.size());

        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        assertEquals(12, list.size());
        assertFalse(list.isEmpty());
    }


    @Test
    public void testSimpleRemove() {
        MyLinkedList list = new MyLinkedList();
        list.add(new Rabbit("1_Rabbit"));
        list.add(new Rabbit("2_Rabbit"));
        list.add(new Rabbit("3_Rabbit"));
        assertEquals(3, list.size());
        assertFalse(list.isEmpty());

        assertTrue(list.remove(new Rabbit("1_Rabbit")));
        assertEquals(2, list.size());

        assertFalse(list.remove(new Rabbit("1_Rabbit")));
        assertEquals(2, list.size());

        assertTrue(list.remove(new Rabbit("2_Rabbit")));
        assertTrue(list.remove(new Rabbit("3_Rabbit")));
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }


    @Test
    public void testSimilarRemove() {
        MyLinkedList list = new MyLinkedList();
        list.add(new Rabbit("Rabbit"));
        list.add(new Rabbit("Rabbit"));
        list.add(new Rabbit("Rabbit"));
        assertEquals(3, list.size());
        assertFalse(list.isEmpty());

        assertTrue(list.remove(new Rabbit("Rabbit")));
        assertEquals(2, list.size());

        assertTrue(list.remove(new Rabbit("Rabbit")));
        assertEquals(1, list.size());

        assertTrue(list.remove(new Rabbit("Rabbit")));
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }


    @Test
    public void testSimpleAddFirst() {
        MyLinkedList list = new MyLinkedList();
        Rabbit rabbit1 = new Rabbit("Rabbit_1");
        Rabbit rabbit2 = new Rabbit("Rabbit_2");
        Rabbit rabbit3 = new Rabbit("Rabbit_#");
        Rabbit rabbit4 = new Rabbit(null);

        list.addFirst(rabbit1);
        list.addFirst(rabbit2);
        list.addFirst(rabbit3);
        list.addFirst(rabbit4);
        list.addFirst(null);

        assertNull(list.get(0));
        assertEquals(rabbit4, list.get(1));
        assertEquals(rabbit3, list.get(2));
        assertEquals(rabbit2, list.get(3));
        assertEquals(rabbit1, list.get(4));
    }


    @Test
    public void testSimpleAddLast() {
        MyLinkedList list = new MyLinkedList();
        Rabbit rabbit1 = new Rabbit("Rabbit_1");
        Rabbit rabbit2 = new Rabbit("Rabbit_2");
        Rabbit rabbit3 = new Rabbit("Rabbit_#");
        Rabbit rabbit4 = new Rabbit(null);

        list.addLast(rabbit1);
        list.addLast(rabbit2);
        list.addLast(rabbit3);
        list.addLast(rabbit4);
        list.addLast(null);

        assertEquals(rabbit1, list.get(0));
        assertEquals(rabbit2, list.get(1));
        assertEquals(rabbit3, list.get(2));
        assertEquals(rabbit4, list.get(3));
        assertNull(list.get(4));
    }


    @Test
    public void testSimpleRemoveLast() {
        MyLinkedList list = new MyLinkedList();
        Rabbit rabbit1 = new Rabbit("Rabbit_1");
        Rabbit rabbit2 = new Rabbit("Rabbit_2");
        Rabbit rabbit3 = new Rabbit("Rabbit_#");
        Rabbit rabbit4 = new Rabbit(null);

        list.add(rabbit1);
        list.add(rabbit2);
        list.add(rabbit3);
        list.add(rabbit4);
        list.add(null);

        assertNull(list.removeLast());
        assertEquals(rabbit4, list.removeLast());
        assertEquals(rabbit3, list.removeLast());
        assertEquals(rabbit2, list.removeLast());
        assertEquals(rabbit1, list.removeLast());
    }

    @Test(expected = NoSuchElementException.class)
    public void testSimpleRemoveLastException() {
        MyLinkedList list = new MyLinkedList();
        Rabbit rabbit1 = new Rabbit("Rabbit_1");
        list.add(rabbit1);

        assertEquals(rabbit1, list.removeLast());

        // remove in empty linked list
        list.removeLast();
    }

    @Test
    public void testSimpleRemoveFirst() {
        MyLinkedList list = new MyLinkedList();
        Rabbit rabbit1 = new Rabbit("Rabbit_1");
        Rabbit rabbit2 = new Rabbit("Rabbit_2");
        Rabbit rabbit3 = new Rabbit("Rabbit_#");
        Rabbit rabbit4 = new Rabbit(null);

        list.add(rabbit1);
        list.add(rabbit2);
        list.add(rabbit3);
        list.add(rabbit4);
        list.add(null);

        assertEquals(rabbit1, list.removeFirst());
        assertEquals(rabbit2, list.removeFirst());
        assertEquals(rabbit3, list.removeFirst());
        assertEquals(rabbit4, list.removeFirst());
        assertNull(list.removeFirst());
    }


    @Test
    public void testSimpleRemoveByIndex() {
        MyLinkedList list = new MyLinkedList();
        Rabbit rabbit1 = new Rabbit("Rabbit_1");
        Rabbit rabbit2 = new Rabbit("Rabbit_2");
        Rabbit rabbit3 = new Rabbit("Rabbit_#");
        Rabbit rabbit4 = new Rabbit(null);

        list.addLast(rabbit1); // position - 0 for rabbit1
        list.addLast(rabbit2); // position - 1 for rabbit2
        list.addLast(rabbit3); // position - 2 for rabbit3
        list.addLast(rabbit4); // position - 3 for rabbit4

        assertEquals(rabbit2, list.remove(1));

        // >>> rabbit2 was removed from 1 position
        // position - 0 for rabbit1
        // position - 1 for rabbit3
        // position - 2 for rabbit4
        assertEquals(rabbit4, list.remove(2));

        // >>> rabbit4 was removed from 2 position
        // position - 0 for rabbit1
        // position - 1 for rabbit3
        assertEquals(rabbit3, list.remove(1));

        // >>> rabbit3 was removed from 1 position
        // position - 0 for rabbit1
        assertEquals(rabbit1, list.remove(0));
    }

}