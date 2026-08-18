package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.TravelAgent;

@Repository
public class TravelAgentRepository {

	
	private List<TravelAgent> agents;
	
	
	
	public TravelAgentRepository(List<TravelAgent> agents) {
		super();
		this.agents = agents;
	}



	public List<TravelAgent> findAll(){
		
		return this.agents;
	}
}
