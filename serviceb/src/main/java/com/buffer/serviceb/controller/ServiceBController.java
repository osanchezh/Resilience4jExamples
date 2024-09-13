package com.buffer.serviceb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/b")
public class ServiceBController {
	@RequestMapping
	public String serviceB() {
		return "Service B is called from Service A";
		
	}
}
