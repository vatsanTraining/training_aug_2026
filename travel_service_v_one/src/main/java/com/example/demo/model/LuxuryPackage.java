package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component("luxury")
public class LuxuryPackage extends TravelPackage {

	
	private boolean isTourGuide;

	public LuxuryPackage() {
		super();
	}

	public LuxuryPackage(String clientName, String destination, boolean isTourGuide) {
		super(clientName, destination);
		this.isTourGuide = isTourGuide;
	}

	public boolean isTourGuide() {
		return isTourGuide;
	}

	public void setTourGuide(boolean isTourGuide) {
		this.isTourGuide = isTourGuide;
	}

	
	@Override
	public double getFees() {
		
		 
		 double amount =5000;
		 
		 if( isTourGuide){
			 
			 amount =9000;
		 }
		 
		 return amount;
	 }
	
	
	
}
