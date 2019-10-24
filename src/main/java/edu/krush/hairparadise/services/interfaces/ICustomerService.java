package edu.krush.hairparadise.services.interfaces;

import edu.krush.hairparadise.model.Customer;

import java.util.List;

public interface ICustomerService {
    List <Customer> getAll();
    Customer get(String id);
    Customer create(Customer customer);
    Customer update(Customer customer);
    Customer delete(String id);

    Customer getByMaxCode();
}
