package edu.krush.hairparadise.model;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
