package com.dima.structure;

import com.dima.model.Rabbit;


public class Node {

    private Node prev;
    private Node next;
    private Rabbit rabbit;

    public Node(Node prev, Rabbit rabbit, Node next) {
        this.prev = prev;
        this.rabbit = rabbit;
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Rabbit getRabbit() {
        return rabbit;
    }
}
