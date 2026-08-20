package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Travel Agent API",version = "1.0"))
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
