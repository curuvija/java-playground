package com.example.petstore.controller;

import com.example.petstore.PetstoreApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import javax.sql.DataSource;
import java.io.IOException;

// this will spinup petstore app on a random port
@SpringBootTest(classes = PetstoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CustomerControllerIntegrationTests {

    @Autowired
    private WebTestClient webClient;

/*    @Bean
    //@Profile("integration")
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/petstore");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");

        return dataSource;
    }*/

    @Test
    void createCustomer() {
        String customer;
        customer = "{\"firstName\":\"Pera\",\"lastName\":\"Peric\",\"email\":\"pera@hotmail.com\"}"; // "{\"firstName\": \"Milos\",}"

        webClient.post()
                .uri("/api/v1/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(customer)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void getCustomerAll() {
        webClient.get().uri("/api/v1/customers").exchange().expectStatus().is2xxSuccessful();
    }
}
