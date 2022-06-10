package com.example.petstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
