package com.example.bookStoreServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
//this class servers end-points
@RestController
public class BookStoreServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookStoreServerApplication.class, args);
	}

	//we want to get something u=out of our server
	@GetMapping
	public List<String> hello() {
		return List.of("Hello", "World!");
	}

}
