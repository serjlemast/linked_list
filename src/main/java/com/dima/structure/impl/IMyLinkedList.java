package com.dima.structure.impl;

import com.dima.model.Rabbit;

public interface IMyLinkedList extends MyList {

    /**
     * Добавление элемента в конец списка с помощью методом addLast(value) выполняется за время O(1).
     */
    public void addLast(Rabbit rabbit);

    /**
     * обавление в начало списка с помощью addFirst(value) выполняется за время O(1).
     */
    public void addFirst(Rabbit rabbit);

    /**
     * Удаление элементов
     * <p>
     * Удалять элементы из списка можно несколькими способами:
     * — из начала или конца списка с помощью removeFirst(), removeLast() за время O(1);
     * — по индексу remove(index) и по значению remove(value) за время O(n).
     */
    public Rabbit removeFirst();

    /**
     * Удаление элементов
     * <p>
     * Удалять элементы из списка можно несколькими способами:
     * — из начала или конца списка с помощью removeFirst(), removeLast() за время O(1);
     * — по индексу remove(index) и по значению remove(value) за время O(n).
     */
    public Rabbit removeLast();

}
