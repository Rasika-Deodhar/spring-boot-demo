package com.example.demo;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

	public static void main(String[] args) {
//		HashMap<String, Object> properties = new HashMap<>();
//		properties.put("server.port", 9000);
//		new SpringApplicationBuilder()            
//		    .properties(properties)
//		    .run(args);
		SpringApplication.run(DemoApplication.class, args);
	}
}
