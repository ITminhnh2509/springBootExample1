package com.example.buoi2mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@EnableMongoRepositories
public class Buoi2mongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Buoi2mongoApplication.class, args);
	}
}
