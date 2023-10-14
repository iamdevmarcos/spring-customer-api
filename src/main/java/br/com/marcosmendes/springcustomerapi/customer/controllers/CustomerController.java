package br.com.marcosmendes.springcustomerapi.customer.controllers;

import br.com.marcosmendes.springcustomerapi.customer.models.CustomerModel;
import br.com.marcosmendes.springcustomerapi.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerModel customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public List<CustomerModel> findAllCustomers() {
        return customerService.findAllCustomers();
    }
}
