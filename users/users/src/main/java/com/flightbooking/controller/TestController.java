package com.flightbooking.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/testing")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String firstPage() {
		return "Hello World";
	}
}
