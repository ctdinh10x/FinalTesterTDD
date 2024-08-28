package com.sdsv.test.service;

import com.sdsv.test.model.Customer;
import com.sdsv.test.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void MessageEmailDuplicate() {
        Customer existingCustomer = Customer.builder().name("Mike").number("C0124").email("mike@java.org").build();
        when(customerRepository.getCustomerByEmail("mike@java.org")).thenReturn(existingCustomer);

        Customer newCustomer = Customer.builder().name("Mike").number("C0125").email("mike@java.org").build();
        String result = customerService.addCustomer(newCustomer);

        assertThat(result).isEqualTo("Email bị trùng lặp");
    }

    @Test
    public void MessageSuccessfullyAddCustomer() {
        Customer newCustomer = Customer.builder().name("Mike").number("C002").email("mike@java.org").build();
        when(customerRepository.getCustomerByEmail("mike@java.org")).thenReturn(null);
        when(customerRepository.addCustomer(newCustomer)).thenReturn(true);

        String result = customerService.addCustomer(newCustomer);

        assertThat(result).isEqualTo("Thêm Customer Thành Công");
    }

    @Test
    public void MessageNonExistingCustomer() {
        when(customerRepository.getCustomerByEmail("ctdinh10x@gmail.com")).thenReturn(null);

        Customer result = customerService.getCustomer("ctdinh10x@gmail.com");

        assertThat(result).isNull();
    }

    @Test
    public void MessageExit() {
        Customer existingCustomer = Customer.builder().name("Tam Dinh").number("C0126").email("quanghuy301001@gmail.com").build();
        when(customerRepository.getCustomerByEmail("quanghuy301001@gmail.com")).thenReturn(existingCustomer);

        Customer result = customerService.getCustomer("quanghuy301001@gmail.com");

        assertThat(result).isEqualTo(existingCustomer);
    }
}
