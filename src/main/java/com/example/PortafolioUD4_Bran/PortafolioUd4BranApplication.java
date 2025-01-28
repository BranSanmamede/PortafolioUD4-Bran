package com.example.PortafolioUD4_Bran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@EntityScan("com.example.models")
@EnableJpaRepositories(basePackages = "com.example.repositories")
public class PortafolioUd4BranApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortafolioUd4BranApplication.class, args);
	}
}