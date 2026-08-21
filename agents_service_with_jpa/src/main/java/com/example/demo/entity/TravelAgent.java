package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.enums.AgentRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "travel_agents")
public class TravelAgent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name",length = 20)
	private String firstName;
	
	@Column(name = "phone_number")
	private long phoneNumber;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	private AgentRole role;
	
	
	public TravelAgent() {
		super();
	}

	public TravelAgent(String firstName, long phoneNumber, LocalDate dateOfBirth, AgentRole role) {
		super();
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
	}

	public TravelAgent(Integer id, String firstName, long phoneNumber, LocalDate dateOfBirth, AgentRole role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AgentRole getRole() {
		return role;
	}

	public void setRole(AgentRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "TravelAgent [id=" + id + ", firstName=" + firstName + ", phoneNumber=" + phoneNumber + ", dateOfBirth="
				+ dateOfBirth + ", role=" + role + "]";
	}
	
	
	
	
}



