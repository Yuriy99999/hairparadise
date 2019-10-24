package edu.krush.hairparadise.repository;

import edu.krush.hairparadise.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findTopByOrderByCodeDesc();
}
