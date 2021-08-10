package com.dima.model;

/**
 *
 */
public class Rabbit {

    /**
     * Name of Rabbit
     */
    private String name;

    public Rabbit(String name) {
        this.name = name;
    }

    public String getName() {
        if (name == null) {
            return null;
        }
        return name;
    }

    @Override
    public String toString() {
        return "Rabbit{" +
                "name='" + name + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        return true;
//    }

}