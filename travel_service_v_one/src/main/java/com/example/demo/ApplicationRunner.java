package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.TravelPackage;
import com.example.demo.services.DemoService;
import com.example.demo.services.TravelService;

@Component
public class ApplicationRunner implements CommandLineRunner {

	
	private DemoService service;
	//private TravelService fileService;
	private TravelService anotherService;
	
	private TravelPackage travel;
	
	
	


	public ApplicationRunner(DemoService service, TravelService anotherService,@Qualifier("luxury") TravelPackage travel) {
		super();
		this.service = service;
		this.anotherService = anotherService;
		this.travel =travel;
		System.out.println("***********  Application Runner is Initialized ***********");
	}



	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.service.getMessage());
		
		travel.setClientName("Shivakumar");
		travel.setDestination("CBE");
		
		anotherService.write(travel);
		
		anotherService.read().forEach(System.out::println);
		
		
	}

}
