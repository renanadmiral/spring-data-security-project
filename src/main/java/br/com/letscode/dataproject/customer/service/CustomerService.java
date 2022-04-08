package br.com.letscode.dataproject.customer.service;

import br.com.letscode.dataproject.customer.model.Customer;
import br.com.letscode.dataproject.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerByRegistration(String registrationNumber) {

        return customerRepository.findByRegistrationNumber(registrationNumber);
    }
}
