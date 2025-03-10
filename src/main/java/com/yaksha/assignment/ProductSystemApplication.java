package com.yaksha.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.yaksha.assignment")
public class ProductSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSystemApplication.class, args);
	}
}
