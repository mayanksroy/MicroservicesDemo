package com.wipro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Docker {
	@GetMapping("/docker")
	public String getData() {
		return "SpringBoot Docker";
	}
}
