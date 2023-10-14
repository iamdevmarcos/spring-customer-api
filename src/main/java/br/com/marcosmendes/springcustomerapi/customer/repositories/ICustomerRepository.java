package br.com.marcosmendes.springcustomerapi.customer.repositories;

import br.com.marcosmendes.springcustomerapi.customer.models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICustomerRepository extends JpaRepository<CustomerModel, UUID> {
    CustomerModel findByCustomerName(String customerName);
    CustomerModel findByCustomerDocument(String customerDocument);
    CustomerModel findByCustomerId(UUID customerId);
}
