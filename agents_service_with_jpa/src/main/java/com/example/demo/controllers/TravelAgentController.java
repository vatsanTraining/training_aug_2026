package com.example.demo.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
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
import com.example.demo.enums.AgentRole;
import com.example.demo.services.TravelAgentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

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
	    @Operation(
	            summary = "Adds a  agent",
	            description = "Adds and Retrieves the newly added  travel agent profile"
	        )
	        @ApiResponses({
	            @ApiResponse(responseCode = "201", description = "Successfully Created Agent "),
	            @ApiResponse(responseCode = "401", description = "Unauthorized access attempt")
	        })

	 public ResponseEntity<TravelAgentDto> save(@Valid @RequestBody TravelAgentDto dto){
		 
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

	    @PutMapping("/update-role")
	    public ResponseEntity<String> updateRoleByFirstName(
	            @RequestParam AgentRole role,
	            @RequestParam String firstName) {
	        
	        int rowsUpdated = this.service.updateRoleByFirstName(role, firstName);
	        
	        if (rowsUpdated == 0) {
	            return ResponseEntity.status(404).body("No travel agents found with the name: " + firstName);
	        }
	        
	        return ResponseEntity.ok("updated " + rowsUpdated  );
	    }
	    @PatchMapping(path = "/{id}")
	    public ResponseEntity<TravelAgentDto> partialUpdate(@PathVariable Integer id, @RequestParam long phoneNumber) {
	        TravelAgentDto updated = this.service.partialUpdate(id, phoneNumber);
	        return ResponseEntity.ok(updated);
	    }

	    @Operation(summary = "Remove an existing agent ", description = "Deletes an agent  permanently from the database table")
	    @ApiResponses({
	        @ApiResponse(responseCode = "204", description = "Agent record successfully Removed"),
	        @ApiResponse(responseCode = "404", description = "Target identifier resource not found in registry")
	    })
	    @DeleteMapping(path = "/{id}")
	    public ResponseEntity<Void> remove(@PathVariable Integer id) {
	        this.service.remove(id);
	        return ResponseEntity.noContent().build();
	    }	 
	 
	 
		 @GetMapping(path = "/sorted")
		 public ResponseEntity<List<TravelAgentDto>> findAllSortedByFirstName() {
			 return ResponseEntity.ok(this.service.findAllSortedByFirstName());
		 }

		    @Operation(
		            summary = "Fetch paginated and sorted list of agents",
		            description = "Retrieves a subset of travel agent profiles with custom sorting options. Pages are 0-indexed."
		        )
		        @ApiResponses({
		            @ApiResponse(responseCode = "200", description = "Successfully retrieved page"),
		            @ApiResponse(responseCode = "401", description = "Unauthorized access attempt")
		        })

		 @GetMapping(path = "/page")
		 public ResponseEntity<Page<TravelAgentDto>> findAllPaginatedAndSorted(
		            @Parameter(description = "Zero-indexed page number to retrieve") 

				 @RequestParam(defaultValue = "0") int page,
				 
		            @Parameter(description = "Number of agent records per page window") 
				 @RequestParam(defaultValue = "10") int size,

		            @Parameter(description = "Database entity property name to order results by") 
				 @RequestParam(defaultValue = "firstName") String sortBy,

				 @RequestParam(defaultValue = "asc") String direction) {
			 
			 Page<TravelAgentDto> resultPage = this.service.findAllPaginatedAndSorted(page, size, sortBy, direction);
			 return ResponseEntity.ok(resultPage);
		 }

	 
	 
}
