package edu.krush.hairparadise.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
@Document
public class Customer {
    @Id
    private String id;
    private int code;
    private String name;
    private String surname;
    private String patronimic;
    private String phoneNumber;
    private Gender gender;
    private Boolean regular;

    public Customer() {
    }

    public Customer(int code, String name, String surname,
                    String patronimic, String phoneNumber, String gender, Boolean regular) {
        this.code = code;
        this.name = name;
        this.surname = surname;
        this.patronimic = patronimic;
        this.phoneNumber = phoneNumber;
        if(gender.equals("male")){
            this.gender = Gender.MALE;
        } else
        {
            this.gender = Gender.FEMALE;
        }
        this.regular = regular;
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

   /* public Gender getGender() {
        return gender;
    }*/

    public String getGender() {
        return gender.getName();
    }

    public void setGender(String gender) {
        if(gender == "male"){
            this.gender = Gender.MALE;
        } else
        {
            this.gender = Gender.FEMALE;
        }
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Boolean isRegular() {
        return regular;
    }

    public void setRegular(Boolean regular) {
        this.regular = regular;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronimic='" + patronimic + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", regular=" + regular +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getId().equals(customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
