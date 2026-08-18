package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.services.DemoService;

@SpringBootApplication
public class TravelServiceVOneApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TravelServiceVOneApplication.class, args);
	
			
		
	}

}

















//ApplicationContext ctx=SpringApplication.run(TravelServiceVOneApplication.class, args);
//
//System.out.println("===="+ctx.getClass().getName());
//
//var mybean = ctx.getBean(DemoService.class);
//
//System.out.println(mybean.getMessage());

