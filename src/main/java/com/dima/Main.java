package com.dima;

import com.dima.model.Rabbit;
import com.dima.structure.MyLinkedList;

public class Main {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.add(new Rabbit("1"));
        list.add(new Rabbit("2"));
        list.add(new Rabbit("3"));
        list.add(new Rabbit("4"));
        list.add(new Rabbit("5"));
        list.add(new Rabbit("6"));
        list.add(new Rabbit("7"));
        System.out.println(list);

        list.remove(new Rabbit("6"));
        System.out.println(list);
        System.out.println(list.get(5));
    }
}
