package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.TravelAgent;
import com.example.demo.repository.TravelAgentRepository;

@Service
public class TravelAgentService {

	
	// using constructor DI
	
	private TravelAgentRepository repo;

	public TravelAgentService(TravelAgentRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<TravelAgent> findAll(){
		
		
		return this.repo.findAll();
	}
}
