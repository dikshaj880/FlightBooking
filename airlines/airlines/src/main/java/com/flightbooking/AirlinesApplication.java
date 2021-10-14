package com.flightbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
@CrossOrigin("http://localhost:4200")
public class AirlinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinesApplication.class, args);
	}

}
