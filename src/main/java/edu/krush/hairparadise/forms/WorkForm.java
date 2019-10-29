package edu.krush.hairparadise.forms;

import edu.krush.hairparadise.model.Customer;
import edu.krush.hairparadise.model.Haircut;
import edu.krush.hairparadise.model.Worker;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WorkForm {
    private String id;
    private Customer customer;
    private int code;
    private String date;
    private String time;
    private Haircut haircut;
    private Worker worker;
    private String status;

    public WorkForm() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
