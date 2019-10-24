package edu.krush.hairparadise.conrollers.rest;

import edu.krush.hairparadise.model.Customer;
import edu.krush.hairparadise.services.impls.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/customer")
@CrossOrigin("*")

@RestController
public class CustomerRestController {

    @Autowired
    CustomerServiceImpl service;

    @RequestMapping ("/list")
    List <Customer> showAll(){
        return service.getAll();
    }

    @RequestMapping ("delete/{id}")
    Customer delete(@PathVariable(value = "id") String id ){
        return service.delete(id);
    }

    @RequestMapping ("/get/{id}")
    Customer get(@PathVariable(value = "id")String id){
        return service.get(id);
    }

    @PostMapping("/create")
    Customer create(@Valid @RequestBody Customer customer) {
        return service.create(customer);
    }

    @PostMapping("/update")
    Customer update(@Valid @RequestBody Customer customer) {
        return service.update(customer);
    }
}
