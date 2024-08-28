package com.sdsv.test.service;

import com.sdsv.test.model.Customer;
import com.sdsv.test.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String addCustomer(Customer customer) {
        if (customerRepository.getCustomerByEmail(customer.getEmail()) != null) {
            return "Customer with this email already exists.";
        }
        return customerRepository.addCustomer(customer) ? "Customer added successfully." : "Failed to add customer.";
    }

    public Customer getCustomer(String email) {
        return customerRepository.getCustomerByEmail(email);
    }

}
