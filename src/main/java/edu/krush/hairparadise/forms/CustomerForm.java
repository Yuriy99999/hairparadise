package edu.krush.hairparadise.forms;

import edu.krush.hairparadise.model.Gender;

public class CustomerForm {
    private String id;
    private int code;
    private String name;
    private String surname;
    private String patronimic;
    private String phoneNumber;
    private String gender;
    private Boolean regular;

    public CustomerForm() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronimic() {
        return patronimic;
    }

    public void setPatronimic(String patronimic) {
        this.patronimic = patronimic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getRegular() {
        return regular;
    }

    public void setRegular(Boolean regular) {
        this.regular = regular;
    }

    @Override
    public String toString() {
        return "CustomerForm{" +
                "id='" + id + '\'' +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronimic='" + patronimic + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", regular=" + regular +
                '}';
    }
}

