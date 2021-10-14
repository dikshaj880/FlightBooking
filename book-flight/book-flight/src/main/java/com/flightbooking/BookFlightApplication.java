package com.flightbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
@EnableSwagger2
@CrossOrigin("http://localhost:4200")
public class BookFlightApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(BookFlightApplication.class, args);
	}

}
