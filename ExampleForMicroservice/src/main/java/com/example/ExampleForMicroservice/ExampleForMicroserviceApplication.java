package com.example.ExampleForMicroservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleForMicroserviceApplication implements CommandLineRunner {
	@Value("${app.message}")
	private String value;

	public static void main(String[] args) {
		SpringApplication.run(ExampleForMicroserviceApplication.class, args);
	}

	@Override
	public void run(String ... args) throws Exception{
		System.out.println(value);
	}

}
