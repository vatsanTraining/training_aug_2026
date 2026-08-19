package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entity.TravelAgent;
import com.example.demo.enums.AgentRole;

public record TravelAgentDto(Integer id,String firstName,long phoneNumber,LocalDate dateOfBirth,AgentRole role) {

}

