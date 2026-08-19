package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TravelAgentDto;
import com.example.demo.entity.TravelAgent;
import com.example.demo.repos.AgentRepository;
import com.example.demo.utils.TravelAgentMapper;

@Service
public class TravelAgentService {

	
	private AgentRepository repo;

	private TravelAgentMapper mapper;
	
	public TravelAgentService(AgentRepository repo,TravelAgentMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		System.out.println(this.repo.getClass().getName());
	}
	
	
	public TravelAgentDto save(TravelAgentDto dto) {
		
		TravelAgent saved= this.repo.save(mapper.toEntity(dto));
		
		return mapper.toDto(saved);
	}
	
	
	public List<TravelAgentDto> findAll(){
		
		return this.repo.findAll()
				  .stream().map(mapper::toDto).toList();
	}
	
	public TravelAgentDto findById(Integer id) {
		
		TravelAgent found = this.repo.findById(id)
				 .orElseThrow(()-> new RuntimeException("Element with  Id:= "+id+ " SNot Present"));
		
		return mapper.toDto(found);
	}
}
