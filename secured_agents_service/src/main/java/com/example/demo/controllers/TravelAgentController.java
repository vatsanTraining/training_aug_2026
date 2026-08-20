package com.example.demo.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.TravelAgent;
import com.example.demo.repos.AgentRepository;


@RestController
@RequestMapping(path = "/api/v1/agents")
public class TravelAgentController {

	
	 private final  AgentRepository service;
	
	 
	 public TravelAgentController(AgentRepository service) {
		super();
		this.service = service;
	}

	 @GetMapping
	 public ResponseEntity<List<TravelAgent>> findAll(){
		 
		 return ResponseEntity.ok(service.findAll());

	 }
	 
		 
	 @PostMapping
	 public ResponseEntity<TravelAgent> save( @RequestBody TravelAgent dto){
		 
		    TravelAgent saved = this.service.save(dto);
		    
		    
		    URI location = ServletUriComponentsBuilder
		    		.fromCurrentRequest()
		    		.path("/{id}")
		    		.buildAndExpand(saved.getId())
		    		.toUri();
		    
		   return ResponseEntity.created(location).body(saved);
	 }
	 
		 
	 
}
