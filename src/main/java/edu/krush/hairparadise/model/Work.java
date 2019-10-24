package edu.krush.hairparadise.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
@Document
public class Work {
    @Id
    private String id;
    private String customerName;
    private int code;
    private LocalDate date;
    private String time;
    private String haircutName;
    private String workerName;
    private String price;
    private String status;
    /*private int workCode;
    private int haircutCode;
    private int customerCode;
    private String workerName;
    private LocalDateTime date;*/

    public Work() {
    }

    public Work(String customerName, int code, LocalDate date, String time, String haircutName,
                String workerName, String price, String status) {
        this.customerName = customerName;
        this.code = code;
        this.date = date;
        this.time = time;
        this.haircutName = haircutName;
        this.workerName = workerName;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getHaircutName() {
        return haircutName;
    }

    public void setHaircutName(String haircutName) {
        this.haircutName = haircutName;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
}
