package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.TravelPackage;
import com.example.demo.services.DemoService;
import com.example.demo.services.FileService;

@Component
public class ApplicationRunner implements CommandLineRunner {

	
	private DemoService service;
	private FileService fileService;
	private TravelPackage travel;
	
	
	public ApplicationRunner(DemoService service,FileService fileService,TravelPackage travel) {
		super();
		this.service = service;
		this.fileService = fileService;
		this.travel =travel;
		System.out.println("***********  Application Runner is Initialized ***********");
	}



	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.service.getMessage());
		
		travel.setClientName("Shivakumar");
		travel.setDestination("CBE");
		
		fileService.write(travel);
		
		fileService.read().forEach(System.out::println);
		
		
	}

}
