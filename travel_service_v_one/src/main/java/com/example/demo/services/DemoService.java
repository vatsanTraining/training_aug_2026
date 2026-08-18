package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service     // configuration meta data
public class DemoService {    //pojo

	
	
	public String getMessage() {
		
		return "IoC with Spring";
	}

	public DemoService() {
		super();
		
		System.out.println("=========  Service Initialized ==========");
	}
}

// see the class name of IoC container in the console