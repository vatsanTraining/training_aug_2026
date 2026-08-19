package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TravelAgentDto;
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
	 public ResponseEntity<List<TravelAgentDto>> findAll(){
		 
		 return ResponseEntity.ok(service.findAll());

	 }
	 
	 @GetMapping(path = "/{id}")
	 public ResponseEntity<TravelAgentDto> findById(@PathVariable int id){
		 
		 return ResponseEntity.ok(service.findById(id));
	 }
	 
	 
	 @PostMapping
	 public ResponseEntity<TravelAgentDto> save(@RequestBody TravelAgentDto dto){
		 
		    TravelAgentDto saved = this.service.save(dto);
		    
		    // Link to the newly created resource
		    
		   return ResponseEntity.status(201).body(saved);
	 }
	 
//	 @PutMapping
//	 
//	 @PatchMapping
//	 
	 @DeleteMapping
	 public ResponseEntity<Void> remove(@PathVariable Integer id){
		 
		 this.service.remove(id);
		 
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		 
		 
		 
	 }
	 
	 
	 
	 
	 
}
