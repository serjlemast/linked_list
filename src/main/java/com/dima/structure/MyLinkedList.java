package com.dima.structure;

import com.dima.model.Rabbit;
import com.dima.structure.impl.IMyLinkedList;

public class MyLinkedList implements IMyLinkedList {

    private int numberOfRabbits = 0;
    private Node first;
    private Node last;

    public MyLinkedList() {
        this.numberOfRabbits = 0;
    }

    @Override
    public boolean remove(Rabbit rabbit) {
            if (first.getRabbit().getName().equals(rabbit.getName())) {
                Node next = first.getNext();
                first = next;
                numberOfRabbits--;
                return true;
            }
            try {
                if (last.getRabbit().getName().equals(rabbit.getName())) {
                    Node prev = last.getPrev();
                    last = null;
                    last = prev;
                    numberOfRabbits--;
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        Node temp = first;
        while (temp.getNext() != null) {
            Rabbit rab = temp.getRabbit();
            if (rab.getName().equals(rabbit.getName())) {
                Node prev = temp.getPrev();
                Node next = temp.getNext();
                temp.setPrev(null);
                temp.setNext(null);
                prev.setNext(next);
                next.setPrev(prev);
                numberOfRabbits--;
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public boolean contains(Rabbit rabbit) {
        Node temp = first;
        if (first.getRabbit().equals(rabbit)) {
            return true;
        }
        if (last.getRabbit().equals(rabbit)) {
            return true;
        }
        while (temp.getNext() != null) {
            if (temp.getRabbit().equals(rabbit)) {
                return true;
            }
            temp = temp.getNext();

        }
        return false;
    }

    public void add(Rabbit rabbit) {
        numberOfRabbits++;
        if (first == null) {
            first = new Node(null, rabbit, null);
            last = first;
        } else {
            Node node = new Node(last, rabbit, null);
            last.setNext(node);
            last = node;
        }
    }

    @Override
    public void addLast(Rabbit rabbit) {
        add(rabbit);
    }

    @Override
    public void addFirst(Rabbit rabbit) {
        if (first == null) {
            first = new Node(null, rabbit, null);
            last = first;
        }
        numberOfRabbits++;
        Node next = first;
        first = new Node(null, rabbit, next);
    }

    @Override
    public Rabbit removeFirst() {
        Rabbit resoult = first.getRabbit();
        Node next = first.getNext();
        first = null;
        first = next;
        return resoult;
    }

    @Override
    public Rabbit removeLast() {
        if (numberOfRabbits > 0) {
            Rabbit resoult = last.getRabbit();
            if (numberOfRabbits == 1) {
                first = null;
                return resoult;
            }
            if (last.getRabbit() == null) {
                numberOfRabbits--;
                Node prev = last.getPrev();
                prev.setNext(null);
                last = null;
                last = prev;
                return null;
            }
            if (last.getRabbit().getName() == null) {
                Node prev = last.getPrev();
                prev.setNext(null);
                last = prev;
                return resoult;
            } else {
                remove(last.getRabbit());
                return resoult;
            }
        }
        return null;
    }


    @Override
    public Rabbit remove(int index) {
        if (numberOfRabbits>0) {
            Rabbit resoult = get(index);
            if (numberOfRabbits == 1) {
                first = null;
                return resoult;
            }
            if (resoult == null || resoult.getName()==null){
                Node temp = first;
                while (temp.getNext() != null) {
                    Rabbit rab = temp.getRabbit();
                    if (rab.getName().equals(resoult.getName())) {
                        Node prev = temp.getPrev();
                        Node next = temp.getNext();
                        temp.setPrev(null);
                        temp.setNext(null);
                        prev.setNext(next);
                        next.setPrev(prev);
                        numberOfRabbits--;
                        return resoult;
                    }
                    temp = temp.getNext();
                }
            }
            remove(resoult);
            return resoult;
        }
        return null;
    }

    @Override
    public Rabbit get(int index) {
        int num = 0;
        if (isEmpty()) {
            return null;
        }
        if (index == 0) {
            return first.getRabbit();
        }
        if (index + 1 == numberOfRabbits) {
            return last.getRabbit();
        }
        Node temp = first;
        while (temp.getNext() != null) {
            if (num == index) {
                return temp.getRabbit();
            }
            num++;
            temp = temp.getNext();

        }
        return null;
    }


    @Override
    public int size() {
        return numberOfRabbits;
    }

    @Override
    public boolean isEmpty() {
        return numberOfRabbits == 0;
    }
}