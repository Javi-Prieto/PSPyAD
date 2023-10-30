package com.example.ExampleForconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ExampleForconfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleForconfigurationApplication.class, args);
	}

}
