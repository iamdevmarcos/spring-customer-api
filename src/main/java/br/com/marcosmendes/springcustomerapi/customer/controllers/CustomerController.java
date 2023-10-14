package br.com.marcosmendes.springcustomerapi.customer.controllers;

import br.com.marcosmendes.springcustomerapi.customer.models.CustomerModel;
import br.com.marcosmendes.springcustomerapi.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerModel customer) {
        return customerService.createCustomer(customer);
    }

}
