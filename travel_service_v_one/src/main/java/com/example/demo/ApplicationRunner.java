package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.services.DemoService;

@Component
public class ApplicationRunner implements CommandLineRunner {

	
	private DemoService service;
	
	
	
	public ApplicationRunner(DemoService service) {
		super();
		this.service = service;
		
		System.out.println("***********  Application Runner is Initialized ***********");
	}



	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.service.getMessage());
		
	}

}
