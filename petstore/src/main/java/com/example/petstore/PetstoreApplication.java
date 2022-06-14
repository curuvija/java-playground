package com.example.petstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO: Add actuator
//TODO: Add prometheus
//TODO: Add tracing
// TODO: Finish creating models https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#data.sql.jpa-and-spring-data
// TODO: Configure hibernate https://www.tutorialspoint.com/hibernate/hibernate_configuration.htm

// REPOSITORY CREATION

// TODO: Clean architecture https://www.baeldung.com/spring-boot-hibernate
// TODO: https://www.javadevjournal.com/spring-boot/spring-boot-with-hibernate/
// TODO: Add auditing model -> https://www.callicoder.com/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/#1-auditmodel

@SpringBootApplication
@RestController
public class PetstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetstoreApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World";
	}
}
