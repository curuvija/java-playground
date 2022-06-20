package com.example.petstore.repository;

import com.example.petstore.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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

    @Test
    public void testUpdateCustomer() {
        Long id = 1L;
        Customer customer = new Customer();
        customer.setFirstName("Milos");
        customer.setLastName("Curuvija");
        customer.setEmail("curuvija@live.com");
        this.customerRepository.save(customer);

        Optional<Customer> persistedCustomer = this.customerRepository.findById(id);
        Customer finalCustomer = persistedCustomer.orElseThrow();
        finalCustomer.setFirstName("Pera");
        finalCustomer.setLastName("Petrovic");
        finalCustomer.setEmail("something@hotmail.com");

        assertDoesNotThrow(
                () -> {
                    this.customerRepository.save(finalCustomer);
                }
        );
        assertEquals(1, finalCustomer.getId());
        assertEquals("Pera", finalCustomer.getFirstName());
        assertEquals("Petrovic", finalCustomer.getLastName());
        assertEquals("something@hotmail.com", finalCustomer.getEmail());
    }

    @Test
    public void testDeleteCustomer() {
        Long id = 1L;
        Customer customer = new Customer();
        customer.setFirstName("Milos");
        customer.setLastName("Curuvija");
        customer.setEmail("curuvija@live.com");
        this.customerRepository.save(customer);

        assertDoesNotThrow(
                () -> {
                    this.customerRepository.deleteById(id);
                }
        );
    }
}
