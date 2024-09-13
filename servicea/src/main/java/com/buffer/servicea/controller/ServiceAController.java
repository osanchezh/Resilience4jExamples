package com.buffer.servicea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.Date;

@RestController
@RequestMapping("/a")
public class ServiceAController {

	public static final String BASE_URL="http://localhost:8081/";
	public static final String SERVICE_A="serviceA";
	int count=1;
	@RequestMapping
	//@CircuitBreaker(name=SERVICE_A, fallbackMethod="serviceAFallback")
	//@Retry(name = SERVICE_A)
	@RateLimiter(name = SERVICE_A)
	public String serviceA() {
		System.out.println("Retry method called " + count++ + " times at " + new Date());
		RestTemplate restTemplate= new RestTemplate();
		return restTemplate.getForObject(BASE_URL+"/b", String.class);
	}
	
	public String serviceAFallback(Exception e) {
		return "This is a fallback method for Service A";
	}
}
