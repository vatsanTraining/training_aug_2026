package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.TravelAgent;

@Configuration
public class AppConfig {

	
	@Bean
	TravelAgent ram() {
		
		return new TravelAgent(1010,"Ramkumar", 89090994);
	}
	
	@Bean
	TravelAgent shyam() {
		
		return new TravelAgent(2010,"Shyamlal", 59090994);
	}
	@Bean
	TravelAgent magesh() {
		
		return new TravelAgent(3010,"Magesh singh", 79090994);
	}
}
