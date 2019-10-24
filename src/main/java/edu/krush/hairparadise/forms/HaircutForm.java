package edu.krush.hairparadise.forms;

import edu.krush.hairparadise.model.Gender;

public class HaircutForm {
    private String id;
    private int code;
    private String name;
    private Gender gender;
    private int cost;

    public HaircutForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "HaircutForm{" +
                "id='" + id + '\'' +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", cost=" + cost +
                '}';
    }
}


