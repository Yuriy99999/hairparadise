package edu.krush.hairparadise.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.Objects;

@Document
public class Work {
    @Id
    private String id;
    private Worker worker;
    private Customer customer;
    private int code;
    private LocalDate date;
    private String time;
    private Haircut haircut;
    private Status status;




    public Work() {
    }

    public Work(Worker worker, Customer customer, int code,
                LocalDate date, String time, Haircut haircut, Status status) {
        this.worker = worker;
        this.customer = customer;
        this.code = code;
        this.date = date;
        this.time = time;
        this.haircut = haircut;
        this.status = status;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Haircut getHaircut() {
        return haircut;
    }

    public void setHaircut(Haircut haircut) {
        this.haircut = haircut;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Work work = (Work) o;
        return getId().equals(work.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Work{" +
                "id='" + id + '\'' +
                ", worker=" + worker +
                ", customer=" + customer +
                ", code=" + code +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", haircut=" + haircut +
                ", status=" + status +
                '}';
    }
}
