package com.example.demo.model;

import org.springframework.stereotype.Component;

//@Component
public class TravelAgent {

	
	private int id;
	private String firstName;
	private long phoneNumber;
	
	
	public TravelAgent() {
		super();
	}
	public TravelAgent(int id, String firstName, long phoneNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	@Override
	public String toString() {
		return "TravelAgent [id=" + id + ", firstName=" + firstName + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
