package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TravelAgent;
import com.example.demo.repos.AgentRepository;

@Service
public class TravelAgentService {

	
	private AgentRepository repo;

	public TravelAgentService(AgentRepository repo) {
		super();
		this.repo = repo;
		System.out.println(this.repo.getClass().getName());
	}
	
	
	public TravelAgent save(TravelAgent agent) {
		
		return this.repo.save(agent);
	}
	
	
	public List<TravelAgent> findAll(){
		
		return this.repo.findAll();
	}
}
