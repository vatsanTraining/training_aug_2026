package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TravelAgent;
import com.example.demo.services.TravelAgentService;

@RestController
@RequestMapping(path = "/api/v1/agents")
public class TravelAgentController {

	
	 private final  TravelAgentService service;
	
	 
	 
	 
	 public TravelAgentController(TravelAgentService service) {
		super();
		this.service = service;
	}




	 @GetMapping
	 public List<TravelAgent> findAll(){
		 
		 return this.service.findAll();
	 }
}
