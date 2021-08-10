package com.dima.structure.impl;

import com.dima.model.Rabbit;

public interface MyList {

    /**
     * Добавление элемента в конец списка с помощью методом add(value) выполняется за время O(1).
     */
    public void add(Rabbit rabbit);


    /**
     * Removes the element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns Rabit that was removed from the list.
     */
    public Rabbit remove(int index);


    public Rabbit get(int index);

    /**
     * Removes first Rabbit in this list.
     */
    public boolean remove(Rabbit rabbit);


    public boolean contains(Rabbit rabbit);

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size();

    /**
     * This implementation returns <tt>size() == 0</tt>.
     */
    public boolean isEmpty();
}
