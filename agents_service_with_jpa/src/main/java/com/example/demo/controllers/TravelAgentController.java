package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TravelAgent;
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
	 
	 @GetMapping(path = "/{id}")
	 public TravelAgent findById(@PathVariable int id){
		 
		 return this.service.findById(id);
	 }
	 
	 
	 @PostMapping
	 public ResponseEntity<TravelAgent> save(@RequestBody TravelAgent entity){
		 
		    TravelAgent saved = this.service.save(entity);
		    
		   return ResponseEntity.status(201).body(saved);
	 }
	 
	 
}
