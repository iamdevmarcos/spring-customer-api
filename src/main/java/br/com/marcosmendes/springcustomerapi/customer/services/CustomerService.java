package br.com.marcosmendes.springcustomerapi.customer.services;

import br.com.marcosmendes.springcustomerapi.customer.models.CustomerModel;
import br.com.marcosmendes.springcustomerapi.customer.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    public ResponseEntity createCustomer(CustomerModel customer) {
        var customerAlreadyExists =
                this.customerRepository.findByCustomerName(customer.getCustomerName());

        if (customerAlreadyExists != null) {
            var formattedErrorMessage = "Customer called " + customer.getCustomerName() + " already exists!";
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
}

