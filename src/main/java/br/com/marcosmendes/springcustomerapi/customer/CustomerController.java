package br.com.marcosmendes.springcustomerapi.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerRepository customerRepository;

    @PostMapping("/")
    public ResponseEntity createCustomer(@RequestBody CustomerModel customer) {
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

}
