package br.com.marcosmendes.springcustomerapi.customer.utils;

import br.com.marcosmendes.springcustomerapi.customer.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    @Autowired
    private ICustomerRepository customerRepository;

    public boolean customerNameAlreadyExists(String customerName) {
        var customerNameAlreadyExists =
            this.customerRepository.findByCustomerName(customerName);

        return customerNameAlreadyExists != null;
    }

    public boolean customerDocumentAlreadyExists(String customerDocument) {
        var customerDocumentAlreadyExists =
            this.customerRepository.findByCustomerDocument(customerDocument);

        return customerDocumentAlreadyExists != null;
    }
}
