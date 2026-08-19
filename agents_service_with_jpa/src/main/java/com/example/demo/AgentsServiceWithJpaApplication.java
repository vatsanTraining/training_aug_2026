package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dto.TravelAgentDto;
import com.example.demo.entity.TravelAgent;
import com.example.demo.enums.AgentRole;
import com.example.demo.services.TravelAgentService;

@SpringBootApplication
public class AgentsServiceWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentsServiceWithJpaApplication.class, args);
	
	
	}

	
//	@Bean
//	CommandLineRunner runner(TravelAgentService service) {
//		
//		//return args -> service.save(new TravelAgent("Kamesh", 7999494, LocalDate.now(), AgentRole.SENIOR));
//	
//		 return args -> service.findAll().forEach(System.out::println);
//		
//	}
}
