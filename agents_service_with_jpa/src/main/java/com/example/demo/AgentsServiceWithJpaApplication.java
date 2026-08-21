package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Travel Agent API",version = "1.0"),
security =@SecurityRequirement(name = "BasicAuth") 
 )

@SecurityScheme(
	    name = "BasicAuth",
	    type = SecuritySchemeType.HTTP,
	    scheme = "basic", // Configures standard HTTP Basic Authentication
	    description = "Enter your system credentials (e.g., india / india) to execute state-changing requests."
	)

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
