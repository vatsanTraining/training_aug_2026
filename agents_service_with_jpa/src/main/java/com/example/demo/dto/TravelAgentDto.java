package com.example.demo.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import com.example.demo.enums.AgentRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record TravelAgentDto(Integer id,
		@NotBlank(message = "First Name should not be blank")
	    @Schema(description = "first name of the Agen", example = "Ashok", requiredMode = Schema.RequiredMode.REQUIRED)
	    String firstName,
		@Range(max = 999999999,min = 111111111,message = "phone number should be eight digit")
		long phoneNumber,
		
		LocalDate dateOfBirth,
	    @Schema(description = "Assigned Role", allowableValues = {"INTERN", "JUNIOR", "SENIOR","MANAGER"}, example = "INTERN")
		AgentRole role) {

}

