package com.example.petstore.repository;

import com.example.petstore.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRespositoryTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testGetAllCustomerReturnsRecords() {
        List<Customer> customers = this.customerRepository.findAll();
        assertAll(
                () -> assertNotNull(customers)
        );
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Milos");
        customer.setLastName("Curuvija");
        customer.setEmail("curuvija@live.com");

        assertDoesNotThrow(
                () -> {
                    Customer result = this.customerRepository.save(customer);
                }
        );
    }
}
