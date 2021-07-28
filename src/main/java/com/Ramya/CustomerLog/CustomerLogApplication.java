package com.Ramya.CustomerLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.Ramya.controller")
@EntityScan(basePackages="com.ramya.model")
@EnableJpaRepositories(basePackages="com.Ramya.dao")
public class CustomerLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerLogApplication.class, args);
	}

}