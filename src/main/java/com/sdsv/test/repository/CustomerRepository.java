package com.sdsv.test.repository;

import com.sdsv.test.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository {
//    public Customer getCustomerByCustomerEmail(String customerEmail) {
//        throw new RuntimeException("Function is not implement");
//    }
//
//    public boolean addCustomer(Customer customer) {
//        throw new RuntimeException("Function is not implemented");
//    }
//
//    public List<Customer> getAllCustomers() {
//        throw new RuntimeException("Function is not implemented");
//    }
private final Map<String, Customer> customerMap = new HashMap<>();

    public Customer getCustomerByEmail(String email) {
        return customerMap.get(email);
    }

    public boolean addCustomer(Customer customer) {
        if (customerMap.containsKey(customer.getEmail())) {
            return false;
        }
        customerMap.put(customer.getEmail(), customer);
        return true;
    }
}
