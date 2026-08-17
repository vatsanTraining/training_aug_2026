package com.example.demo;

public class TravelPackage  {

	private String clientName;
	 private String  destination;
	 
	 
	 
	 
	 public TravelPackage() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	 public TravelPackage(String clientName, String destination) {
		super();
		this.clientName = clientName;
		this.destination = destination;
	}


	 public String getClientName() {
		 return clientName;
	 }
	 public void setClientName(String clientName) {
		 this.clientName = clientName;
	 }
	 public String getDestination() {
		 
		 
		 return destination;
	 }
	 public void setDestination(String destination) {
		 
		 if(destination.equalsIgnoreCase("CBE")) {
		    this.destination = destination;
		 } else {
			 System.out.println("Invalid Code");
		 }
		 
	 }
	 
	 public double getFees() {
		 
		 double amount =5000;
		 
		 if( destination.startsWith("C")){
			 
			 amount =6000;
		 }
		 
		 return amount;
	 }


	 @Override
	 public String toString() {

		 return this.clientName + ","+this.destination;
	 }
	 
}
