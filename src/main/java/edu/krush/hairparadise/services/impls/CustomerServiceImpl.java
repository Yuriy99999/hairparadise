package edu.krush.hairparadise.services.impls;

import edu.krush.hairparadise.model.Customer;
import edu.krush.hairparadise.repository.CustomerRepository;
import edu.krush.hairparadise.services.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {

    List<Customer> customers = new ArrayList<>();

    @Autowired
    CustomerRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();

        Customer customer1 = new Customer(1,"Lisa", "Vasilyeva",
                "Aleksandrovna", "0663333333", "female", false);
        Customer customer2 = new Customer(2,"Anton", "Antonov",
                "Antonovich", "0505555555", "male", false);
        Customer customer3 = new Customer(3,"Anna", "Karpyuk",
                "Alekseevna", "0972222222", "female", false);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        repository.saveAll(customers);
    }


    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer delete(String id) {
        Customer customer = this.get(id);
        repository.deleteById(id);
        return customer;
    }

    @Override
    public Customer getByMaxCode() {
        return repository.findTopByOrderByCodeDesc();
    }


}
