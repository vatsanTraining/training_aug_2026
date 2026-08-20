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
	 
	 @GetMapping(path = "/srch/firstName/{name}")
	 public ResponseEntity<List<TravelAgentDto>> findByFirstName(@PathVariable String name){
		 
		 return ResponseEntity.ok(service.findByFirstName(name));
	 }

	 @GetMapping(path = "/srch/grThanId/{id}")
	 public ResponseEntity<List<TravelAgentDto>> findByIdGrtThan(@PathVariable int id){
		 
		 return ResponseEntity.ok(service.findByIdGrtThan(id));
	 }

	 @GetMapping(path = "/srch/dateOfBirth")
	 public ResponseEntity<List<TravelAgentDto>> findByDateOfBirth(@RequestParam LocalDate date){
		 
		 return ResponseEntity.ok(service.getByDateOfBirth(date));
	 }
 
	 
	 @PostMapping
	 public ResponseEntity<TravelAgentDto> save(@RequestBody TravelAgentDto dto){
		 
		    TravelAgentDto saved = this.service.save(dto);
		    
		    
		    URI location = ServletUriComponentsBuilder
		    		.fromCurrentRequest()
		    		.path("/{id}")
		    		.buildAndExpand(saved.id())
		    		.toUri();
		    
		   return ResponseEntity.created(location).body(saved);
	 }
	 
	   @PutMapping(path = "/{id}")
	    public ResponseEntity<TravelAgentDto> update(@PathVariable Integer id, @RequestBody TravelAgentDto dto) {
	        TravelAgentDto updated = this.service.update(id, dto);
	        return ResponseEntity.ok(updated);
	    }

	    @PatchMapping(path = "/{id}")
	    public ResponseEntity<TravelAgentDto> partialUpdate(@PathVariable Integer id, @RequestParam long phoneNumber) {
	        TravelAgentDto updated = this.service.partialUpdate(id, phoneNumber);
	        return ResponseEntity.ok(updated);
	    }

	    @DeleteMapping(path = "/{id}")
	    public ResponseEntity<Void> remove(@PathVariable Integer id) {
	        this.service.remove(id);
	        return ResponseEntity.noContent().build();
	    }	 
	 
	 
	 
	 
}
