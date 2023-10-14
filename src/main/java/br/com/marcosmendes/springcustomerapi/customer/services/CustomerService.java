package br.com.marcosmendes.springcustomerapi.customer.services;

import br.com.marcosmendes.springcustomerapi.customer.models.CustomerModel;
import br.com.marcosmendes.springcustomerapi.customer.repositories.ICustomerRepository;
import br.com.marcosmendes.springcustomerapi.customer.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private Utils utils;

    public ResponseEntity createCustomer(CustomerModel customer) {
        if (utils.customerNameAlreadyExists(customer.getCustomerName())) {
            var formattedErrorMessage = "Customer called " + customer.getCustomerName() + " already exists!";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(formattedErrorMessage);
        }

        if (utils.customerDocumentAlreadyExists(customer.getCustomerDocument())) {
            var formattedErrorMessage = "Customer with document " + customer.getCustomerDocument() + " already exists";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(formattedErrorMessage);
        }

        customer.setCreatedAt(LocalDateTime.now());
        var createdCustomer = this.customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @Transactional(readOnly = true)
    public List<CustomerModel> findAllCustomers() {
        return this.customerRepository.findAll();
    }

    public ResponseEntity findByCustomerId(UUID customerId) {
        var customer = this.customerRepository.findByCustomerId(customerId);

        if (customer == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Found!");

        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }
}

