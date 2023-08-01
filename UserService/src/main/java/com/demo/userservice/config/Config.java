package com.demo.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	
	@Bean
	@LoadBalanced  //used so it will understand our RATING-SERVICE and other names
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
