package com.example.demo.utils;

import org.springframework.stereotype.Component;

import com.example.demo.dto.TravelAgentDto;
import com.example.demo.entity.TravelAgent;

@Component
public class TravelAgentMapper {

	
	public TravelAgent toEntity(TravelAgentDto dto) {
		
		return new TravelAgent(dto.id(), dto.firstName(), 
				dto.phoneNumber(), dto.dateOfBirth(), dto.role());
	}
	
	public TravelAgentDto toDto(TravelAgent entity) {
		
		return new TravelAgentDto(entity.getId(),
				entity.getFirstName(), entity.getPhoneNumber(), 
				entity.getDateOfBirth(), entity.getRole());
	}
	
}
