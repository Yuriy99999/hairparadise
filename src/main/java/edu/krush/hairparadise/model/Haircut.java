package edu.krush.hairparadise.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
@Document
public class Haircut {
    @Id
    private String id;
    private int code;
    private String name;
    private Gender gender;
    private int cost;

    public Haircut() {
    }

    public Haircut(int code, String name, Gender gender, int cost) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.cost = cost;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Haircut haircut = (Haircut) o;
        return getId().equals(haircut.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
