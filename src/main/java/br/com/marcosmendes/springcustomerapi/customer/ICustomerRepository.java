package br.com.marcosmendes.springcustomerapi.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICustomerRepository extends JpaRepository<CustomerModel, UUID> {
    CustomerModel findByCustomerName(String customerName);
}
