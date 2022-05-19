package com.curuvija.petstore;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@SpringBootApplication
@RestController
public class PetstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetstoreApplication.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
}
