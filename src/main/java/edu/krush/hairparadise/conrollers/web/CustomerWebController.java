package edu.krush.hairparadise.conrollers.web;

import edu.krush.hairparadise.forms.CustomerForm;
import edu.krush.hairparadise.model.Customer;
import edu.krush.hairparadise.model.Gender;
import edu.krush.hairparadise.services.impls.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@RequestMapping("/customer")
@CrossOrigin("*")
@Controller
public class CustomerWebController {

    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping ("customer/list")
    public String showAll(Model model){
        List<Customer> list = customerService.getAll();
        model.addAttribute("customers", list);

        return "worker/customerList";
    }

    @RequestMapping ("admin/customer/list")
    public String showAll1(Model model){
        List<Customer> list = customerService.getAll();
        model.addAttribute("customers", list);

        return "admin/adminCustomerList";
    }


    @RequestMapping("customer/delete/{id}")
    String delete(Model model, @PathVariable(value = "id") String id) {
        customerService.delete(id);
        List<Customer> list = customerService.getAll();

        return "redirect:/customer/list";
    }

    @RequestMapping("admin/customer/delete/{id}")
    String delete1(Model model, @PathVariable(value = "id") String id) {
        customerService.delete(id);
        List<Customer> list = customerService.getAll();
        //model.addAttribute("customers", list);
        return "redirect:/admin/customer/list";

    }

    @RequestMapping(value = "customer/create", method = RequestMethod.GET)
    public String addCustomer(Model model){
        CustomerForm form = new CustomerForm();

        Map<String, String> genders = Arrays.asList(Gender.values()).
                stream().collect(Collectors.toMap(Gender::getName, Gender::getName));
        model.addAttribute(form);
        model.addAttribute("genders", genders);
        return "/worker/customerAdd";

    }

    @RequestMapping(value = "customer/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("customerForm") CustomerForm form){
            int code = customerService.getByMaxCode().getCode()+1;
            Customer customer = new Customer(
                    code,
                    form.getName(),
                    form.getSurname(),
                    form.getPatronimic(),
                    form.getPhoneNumber(),
                    form.getGender(),
                    false);

        customerService.create(customer);

        return "redirect:/customer/list";
    }

    @RequestMapping(value = "admin/customer/create", method = RequestMethod.GET)
    public String addCustomer1(Model model){
        CustomerForm form = new CustomerForm();
        Map<String, String> genders = Arrays.asList(Gender.values()).
                stream().collect(Collectors.toMap(Gender::getName, Gender::getName));
        model.addAttribute(form);
        model.addAttribute("genders", genders);
        return "/admin/adminCustomerAdd";

    }

    @RequestMapping(value = "admin/customer/create", method = RequestMethod.POST)
    public String create1(@ModelAttribute("customerForm") CustomerForm form){
        int code = customerService.getByMaxCode().getCode()+1;
        Customer customer = new Customer(
                code,
                form.getName(),
                form.getSurname(),
                form.getPatronimic(),
                form.getPhoneNumber(),
                form.getGender(),
                false);

        customerService.create(customer);

        return "redirect:/admin/customer/list";
    }



    @RequestMapping
    public String main(Map<String, Object> model){
        return "main";
    }


}
