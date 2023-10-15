package br.com.marcosmendes.springcustomerapi.customer.controllers;

import br.com.marcosmendes.springcustomerapi.customer.models.CustomerModel;
import br.com.marcosmendes.springcustomerapi.customer.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
@Tag(name = "spring-customer-api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Operation(summary = "Create a client", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Customer Already Exists!"),
            @ApiResponse(responseCode = "400", description = "Customer Document Already Exists!"),
    })
    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerModel customer) {
        return this.customerService.createCustomer(customer);
    }

    @Operation(summary = "Returns a general list of all customers", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok")
    })
    @GetMapping
    public List<CustomerModel> findAllCustomers() {
        return this.customerService.findAllCustomers();
    }

    @Operation(summary = "Returns a specific customer according to id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Customer Not Found!")
    })
    @GetMapping(value = "/{customerId}")
    public ResponseEntity findCustomerById(@PathVariable UUID customerId) {
        return this.customerService.findByCustomerId(customerId);
    }
}
