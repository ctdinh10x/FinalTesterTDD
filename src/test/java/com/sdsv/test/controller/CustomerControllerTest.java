package com.sdsv.test.controller;

import com.sdsv.test.model.Customer;
import com.sdsv.test.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerControllerTest {
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Test
    public void CustomerInforFound() {
        Customer fakeCustomer = Customer.builder().name("Tam Dinh").number("C0124").email("chutamdinh3010@gmail.com").build();
        when(customerService.getCustomer("chutamdinh3010@gmail.com")).thenReturn(fakeCustomer);

        ResponseEntity<Customer> response = customerController.getCustomer("chutamdinh3010@gmail.com");

        assertThat(response.getStatusCodeValue()).isEqualTo(200);

        Customer result = response.getBody();

        assertThat(result.getName()).isEqualTo("Tam Dinh");
        assertThat(result.getNumber()).isEqualTo("C0124");
        assertThat(result.getEmail()).isEqualTo("chutamdinh3010@gmail.com");
    }

    @Test
    public void CustomerInforNotFound() {
        when(customerService.getCustomer("quanghuy301001@gmail.com")).thenReturn(null);

        ResponseEntity<Customer> response = customerController.getCustomer("quanghuy301001@gmail.com");

        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }
}
