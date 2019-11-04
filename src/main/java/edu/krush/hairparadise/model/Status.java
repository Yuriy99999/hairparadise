package edu.krush.hairparadise.model;

public enum Status {
    AWAITING("awaiting"),
    DONE("done");

    private String name;

    Status(String name) {
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
